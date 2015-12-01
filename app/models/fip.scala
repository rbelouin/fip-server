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

  implicit val system = ActorSystem("fip-actor-system")
  implicit val materializer = ActorMaterializer()

  val source = FipSource.source(2.seconds, getFipData _)

  def getFipData: Future[JsValue] = {
    val url = "http://www.fipradio.fr/sites/default/files/import_si/si_titre_antenne/FIP_player_current.json"

    WS.url(url).get().map(_.body).map(Json.parse _)
  }

  def getCurrentSong: Future[Either[InvalidSongData, Song]] = {
    source.map(Song.fromJson _).runWith(Sink.head)
  }

  def getCurrentShow: Future[Either[InvalidShowData, Show]] = {
    source.map(Show.fromJson _).runWith(Sink.head)
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
      source
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
      source
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
      val s_song = source
        .map(Song.fromJson _)
        .map(toJson("song", _))

      val s_show = source
        .map(Show.fromJson _)
        .map(toJson("show", _))

      Source.combine(s_song, s_show)(n => Merge(n))
        .runWith(Sink.actorRef(self, PoisonPill))
    }

    override def receive = {
      case (json: JsValue) => out ! json
    }
  })
}
