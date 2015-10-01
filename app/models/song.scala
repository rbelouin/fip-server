package models

import play.api._
import play.api.libs.json._
import play.api.libs.ws._

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

case class SongInput(
  id: String,
  titre: String,
  interpreteMorceau: String,
  startTime: Long
)
  
case class Song(
  id: String,
  title: String,
  author: String,
  startTime: Long
)

object Song {
  import Play.current

  implicit val sif = Json.format[SongInput]
  implicit val sf = Json.format[Song]

  def fromInput(input: SongInput): Song = {
    Song(input.id, input.titre, input.interpreteMorceau, input.startTime)
  }

  def parse(json: String): Option[Song] = {
    val jsvalue = Json.parse(json)
    
    (jsvalue \ "current" \ "song").asOpt[SongInput].map(fromInput _)
  }

  def fetchCurrentSong: Future[Option[Song]] = {
    WS.url("http://www.fipradio.fr/sites/default/files/import_si/si_titre_antenne/FIP_player_current.json").get().map(_.body).map(parse _)
  }
}
