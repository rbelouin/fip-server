package models

import play.api._
import play.api.libs.json._

case class FipSongInput(
  uuid: String,
  start: Long,
  end: Long,
  title: String,
  authors: Option[String],
  titreAlbum: Option[String],
  anneeEditionMusique: Option[Int],
  label: Option[String],
  visual: Option[String],
  path: Option[String]
)

case class FipSong(
  id: String,
  startTime: Long,
  endTime: Long,
  title: String,
  artist: Option[String],
  album: Option[String],
  year: Option[String],
  label: Option[String],
  icons: Map[String, String],
  itunes: Option[String]
)

object FipSong {
  implicit val fsir = Json.reads[FipSongInput]
  implicit val fsr = fsir.map(fromInput _)
  implicit val fsw = Json.writes[FipSong]

  def fromInput(input: FipSongInput): FipSong = FipSong(
    input.uuid,
    input.start,
    input.end,
    input.title,
    input.authors,
    input.titreAlbum,
    input.anneeEditionMusique.map(_.toString),
    input.label,
    input.visual
      .orElse(Configuration.defaultCover)
      .map(visual => Map("medium" -> visual))
      .getOrElse(Map.empty),
    input.path
  )
}

sealed abstract class FipData(val `type`: String)
case class FipDataSong(song: FipSong) extends FipData("song")
  
object FipData {
  import Error._
  import FipSong._

  class FipDataFormat extends Format[FipData] {
    override def reads(json: JsValue) = for {
      levels <- (json \ "levels").validate[JsArray]
      position <- (levels(0) \ "position").validate[Int]
      items <- (levels(0) \ "items").validate[JsArray]
      item <- items(position).validate[String]
      steps <- (json \ "steps").validate[JsObject]
      step <- (steps \ item).validate[FipSong]
    } yield FipDataSong(step)
    
    override def writes(data: FipData) = data match {
      case FipDataSong(song) => JsObject(Seq(
        "type" -> JsString("song"),
        "song" -> Json.toJson(song)
      ))
    }
  }

  implicit val fdf = new FipDataFormat

  def rewriteJson(json: JsValue): JsValue = {
    json.validate[Map[String, JsValue]].fold(
      e => Json.toJson(InvalidFipData(e)),
      sources => Json.toJson(sources.mapValues(json => {
        json.validate[FipData].fold(
          e => Json.toJson(InvalidSongData(e)),
          data => Json.toJson(data)
        )
      }))
    )
  }
}
