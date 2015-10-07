package models

import play.api._
import play.api.libs.json._
import play.api.libs.ws._

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

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

  def fetchCurrentSong: Future[Option[Song]] = {
    WS.url("http://www.fipradio.fr/sites/default/files/import_si/si_titre_antenne/FIP_player_current.json").get().map(_.body).map(parse _)
  }
}
