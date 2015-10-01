package models

import play.api.libs.json._

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
  implicit val sif = Json.format[SongInput]
  implicit val sf = Json.format[Song]

  def fromInput(input: SongInput): Song = {
    Song(input.id, input.titre, input.interpreteMorceau, input.startTime)
  }

  def parse(json: String): Option[Song] = {
    val jsvalue = Json.parse(json)
    
    (jsvalue \ "current" \ "song").asOpt[SongInput].map(fromInput _)
  }
}
