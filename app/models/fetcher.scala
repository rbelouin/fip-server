package models

import play.api.libs.json._

import scala.concurrent._
import scala.concurrent.duration._

import akka.actor._

object Fetcher {
  sealed trait Command
  case object FetchCommand extends Command
  case object GetCommand extends Command
  case class ConnectCommand(ref: ActorRef) extends Command
  case class DisconnectCommand(ref: ActorRef) extends Command

  def props[A](interval: FiniteDuration, fetch: () => Future[A], initial: Option[A] = None) = Props(new Fetcher(interval, fetch, initial))
}

class Fetcher[A](interval: FiniteDuration, fetch: () => Future[A], initial: Option[A]) extends Actor {
  import Fetcher._
  import context.dispatcher

  var a: Option[A] = initial
  var listeners: Set[ActorRef] = Set()

  override def preStart = {
    context.system.scheduler.schedule(0.seconds, interval, self, FetchCommand)
  }

  override def receive = {
    case FetchCommand => {
      fetch().map(value => {
        if(Some(value) != a) {
          listeners.foreach(ref => {
            ref ! Listener.DataMessage(value)
          })
        }

        a = Some(value)
      })
    }
    case GetCommand => {
      a.foreach(value => {
        sender ! value
      })
    }
    case ConnectCommand(ref) => {
      listeners = listeners + ref
      a.foreach(value => {
        ref ! Listener.DataMessage(value)
      })
    }
    case DisconnectCommand(ref) => {
      listeners = listeners - ref
    }
  }
}

object Listener {
  sealed trait Message
  case class DataMessage[A](data: A) extends Message

  def props[A](fetcher: ActorRef, out: ActorRef, toJson: A => JsValue) = Props(new Listener(fetcher, out, toJson))
}

class Listener[A](fetcher: ActorRef, out: ActorRef, toJson: A => JsValue) extends Actor {
  import Listener._

  override def preStart = {
    fetcher ! Fetcher.ConnectCommand(self)
  }

  override def postStop = {
    fetcher ! Fetcher.DisconnectCommand(self)
  }

  override def receive = {
    case (msg: DataMessage[A]) => out ! toJson(msg.data)
    case obj => println(obj)
  }
}
