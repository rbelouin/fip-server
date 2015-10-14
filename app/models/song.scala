package models

import play.api._
import play.api.libs.json._
import play.api.libs.ws._

import scala.concurrent._
import scala.concurrent.duration._

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import akka.stream.ActorMaterializer
import akka.stream.actor.ActorPublisher
import akka.stream.scaladsl._

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

object Song {
  import Play.current

  implicit val sif = Json.format[SongInput]
  implicit val sf = Json.format[Song]

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

  def parse(json: String): Option[Song] = {
    val jsvalue = Json.parse(json)
    
    (jsvalue \ "current" \ "song").asOpt[SongInput].map(fromInput _)
  }
}

object SongFetcher {
  import Play.current

  case object CurrentSongRequest
  case object SongFetchRequest

  val url = "http://www.fipradio.fr/sites/default/files/import_si/si_titre_antenne/FIP_player_current.json"

  implicit val system = ActorSystem("fip-actor-system")
  implicit val timeout = Timeout(5.seconds)

  def props(url: String)(implicit app: Application) =
    Props(new SongFetcher(url, app))

  val fetcher = system.actorOf(props(url))

  def fetchCurrent: Future[Option[Song]] = {
    (fetcher ? CurrentSongRequest).mapTo[Option[Song]]
  }
}

class SongFetcher(url: String, app: Application) extends ActorPublisher[Option[Song]] {
  import SongFetcher._
  import context.dispatcher

  var song: Option[Song] = None

  override def preStart = {
    context.system.scheduler.schedule(0.seconds, 2.seconds, self, SongFetchRequest)
  }

  override def receive = {
    case SongFetchRequest => {
      fetchCurrentSong.map(m_song => {
        song = m_song
      })
    }
    case CurrentSongRequest => {
      sender() ! song
    }
  }

  def fetchCurrentSong: Future[Option[Song]] = {
    implicit val application = app

    WS.url(url).get().map(_.body).map(Song.parse _)
  }
}
