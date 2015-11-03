package models

import scala.concurrent._
import scala.concurrent.duration._

import akka.actor._

object Fetcher {
  sealed trait Command
  case object FetchCommand extends Command
  case object GetCommand extends Command

  def props[A](interval: FiniteDuration, fetch: () => Future[A], initial: Option[A] = None) = Props(new Fetcher(interval, fetch, initial))
}

class Fetcher[A](interval: FiniteDuration, fetch: () => Future[A], initial: Option[A]) extends Actor {
  import Fetcher._
  import context.dispatcher

  var a: Option[A] = initial

  override def preStart = {
    context.system.scheduler.schedule(0.seconds, interval, self, FetchCommand)
  }

  override def receive = {
    case FetchCommand => {
      fetch().map(value => {
        a = Some(value)
      })
    }
    case GetCommand => {
      a.foreach(value => {
        sender ! value
      })
    }
  }
}
