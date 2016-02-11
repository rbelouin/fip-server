package models

import play.api._
import play.api.libs.json._

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import akka.stream.actor._

object Fetcher {
  sealed trait Message
  case object FetchMessage

  def props(interval: FiniteDuration, fetch: () => Future[JsValue]) = {
    Props(new Fetcher(interval, fetch))
  }

  def source(interval: FiniteDuration, fetch: () => Future[JsValue])(implicit system: ActorSystem, materializer: ActorMaterializer) = {
    Source.actorPublisher(props(interval, fetch))
  }
}

class Fetcher(interval: FiniteDuration, fetch: () => Future[JsValue])
  extends ActorPublisher[JsValue] {

  import Fetcher._
  import ActorPublisherMessage._

  var o_json: Option[JsValue] = None

  def send() = {
    if(isActive && totalDemand > 0) {
      o_json foreach onNext
    }
  }

  override def preStart = {
    val delay = 0.seconds
    context.system.scheduler.schedule(delay, interval, self, FetchMessage)
  }
  
  override def receive = {
    case FetchMessage => fetch().map(value => {
      o_json = Some(value)
      send()
    })
    case Request(_) => send()
    case Cancel => context.stop(self)
  }
}
