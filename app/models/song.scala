package models

import play.api._
import play.api.libs.json._
import play.api.libs.ws._
import play.api.data.validation._

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout

case class FipResponse(current: FipResponseCurrent)
case class FipResponseCurrent(song: SongInput)

case class SongInput(
  id: String,
  startTime: Long,
  endTime: Long,
  titre: String,
  titreAlbum: String,
  interpreteMorceau: String,
  anneeEditionMusique: String,
  label: Option[String],
  visuel: Map[String, String],
  lien: String
)
  
case class Song(
  id: String,
  startTime: Long,
  endTime: Long,
  title: String,
  album: String,
  artist: String,
  year: String,
  label: Option[String],
  icons: Map[String, String],
  itunes: String
)

class JsErrorWrites extends Writes[Seq[(JsPath, Seq[ValidationError])]] {
  override def writes(errors: Seq[(JsPath, Seq[ValidationError])]): JsValue = {
   JsArray(errors.map {
      case (path, errors) => {
        JsObject(Seq(
          "path" -> JsString(path.toJsonString),
          "errors" -> JsArray(errors.map(err => JsString(err.message)))
        ))
      }
    })
  }
}

object Song {
  import Play.current

  implicit val sif = Json.format[SongInput]
  implicit val sf = Json.format[Song]
  implicit val frcf = Json.format[FipResponseCurrent]
  implicit val frf = Json.format[FipResponse]

  def fromInput(input: SongInput): Song = {
    Song(
      input.id,
      input.startTime,
      input.endTime,
      input.titre,
      input.titreAlbum,
      input.interpreteMorceau,
      input.anneeEditionMusique,
      input.label,
      input.visuel,
      input.lien
    )
  }

  def parse(json: String): JsResult[Song] = {
    val result = Json.parse(json).validate[FipResponse]

    result.map(_.current.song).map(fromInput _)
  }
}

object SongFetcher {
  import Play.current
  import Fetcher._
  import Song._

  implicit val system = ActorSystem("fip-actor-system")
  implicit val timeout = Timeout(5.seconds)
  implicit val ew = new JsErrorWrites

  def fetchCurrentSong: Future[JsResult[Song]] = {
    val url = "http://www.fipradio.fr/sites/default/files/import_si/si_titre_antenne/FIP_player_current.json"

    WS.url(url).get().map(_.body).map(Song.parse _)
  }

  def toJson(result: JsResult[Song]) = result.fold[JsValue](Json.toJson(_), Json.toJson(_))

  val fetcher = system.actorOf(Fetcher.props(2.seconds, fetchCurrentSong _))

  def fetchCurrent: Future[JsResult[Song]] = {
    (fetcher ? GetCommand).mapTo[JsResult[Song]]
  }

  def listen(out: ActorRef) = {
    Listener.props(fetcher, out, toJson _)
  }
}
