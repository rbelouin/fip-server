package models

import play.api._
import play.api.libs.json._
import play.api.libs.ws._
import play.api.data.validation._

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import akka.actor._
import akka.stream._
import akka.stream.scaladsl._
import akka.pattern.ask
import akka.util.Timeout

object Fip {
  import Error._
  import Play.current

  val conf = Configuration

  implicit val system = ActorSystem(conf.actorSystemName)
  implicit val materializer = ActorMaterializer()

  def getSourceData(url: String): Future[JsValue] = {
    WS.url(url).get().map(_.body).map(Json.parse _)
  }

  def getSourcesData: Future[JsValue] = {
    val data: List[Future[(String, JsValue)]] = conf.sources.map {
      case (name, url) => getSourceData(url).map(name -> _)
    }.toList

    Future.sequence(data).map(_.toSeq).map(JsObject(_))
  }

  val oldSource = FipSource.source(conf.actorTimeout, () => getSourceData(conf.oldSource.get))
  val source = FipSource.source(conf.actorTimeout, getSourcesData _)

  def getCurrentSong: Future[Either[InvalidSongData, Song]] = {
    oldSource.map(Song.fromJson _).runWith(Sink.head)
  }

  def getCurrentShow: Future[Either[InvalidShowData, Show]] = {
    oldSource.map(Show.fromJson _).runWith(Sink.head)
  }

  def toJson[E, A](name: String, e_a: Either[E, A])(implicit ew: Writes[E], aw: Writes[A]): JsValue = {
    e_a.fold[JsValue](
      error => JsObject(Seq(
        "type" -> JsString("error"),
        "error" -> Json.toJson(error)
      )),
      a => JsObject(Seq(
        "type" -> JsString(name),
        name -> Json.toJson(a)
      ))
    )
  }

  def getSongs(out: ActorRef) = Props(new Actor {
    override def preStart = {
      oldSource
        .map(Song.fromJson _)
        .map(toJson("song", _))
        .runWith(Sink.actorRef(self, PoisonPill))
    }

    override def receive = {
      case (json: JsValue) => out ! json
    }
  })

  def getShows(out: ActorRef) = Props(new Actor {
    override def preStart = {
      oldSource
        .map(Show.fromJson _)
        .map(toJson("show", _))
        .runWith(Sink.actorRef(self, PoisonPill))
    }

    override def receive = {
      case (json: JsValue) => out ! json
    }
  })

  def getAll(out: ActorRef) = Props(new Actor {
    override def preStart = {
      source.map(FipData.rewriteJson _)
        .runWith(Sink.actorRef(self, PoisonPill))
    }

    override def receive = {
      case (json: JsValue) => out ! json
    }
  })
}
