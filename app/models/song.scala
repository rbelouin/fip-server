package models

import play.api._
import play.api.libs.json._

case class SongInput(
  id: String,
  startTime: Long,
  endTime: Long,
  titre: String,
  titreAlbum: String,
  interpreteMorceau: String,
  anneeEditionMusique: Option[String],
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
  year: Option[String],
  label: Option[String],
  icons: Map[String, String],
  itunes: String
)

object Song {
  import Error._

  implicit val songInputFormat = Json.format[SongInput]
  implicit val songFormat = Json.format[Song]

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

  def fromJson(json: JsValue): Either[InvalidSongData, Song] = {
    val result = (json \ "current" \ "song").validate[SongInput]
    result.fold(e => Left(InvalidSongData(e)), s => Right(fromInput(s)))
  }
}
