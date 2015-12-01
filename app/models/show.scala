package models

import play.api._
import play.api.libs.json._

case class ShowInput(
  id: String,
  startTime: Long,
  endTime: Long,
  titre: String,
  visuel: Map[String, String]
)
  
case class Show(
  id: String,
  startTime: Long,
  endTime: Long,
  name: String,
  icons: Map[String, String]
)

object Show {
  import Error._

  implicit val showInputFormat = Json.format[ShowInput]
  implicit val showFormat = Json.format[Show]

  def fromInput(input: ShowInput): Show = {
    Show(
      input.id,
      input.startTime,
      input.endTime,
      input.titre,
      input.visuel
    )
  }

  def fromJson(json: JsValue): Either[InvalidShowData, Show] = {
    val result = (json \ "current" \ "emission").validate[ShowInput]
    result.fold(e => Left(InvalidShowData(e)), s => Right(fromInput(s)))
  }
}
