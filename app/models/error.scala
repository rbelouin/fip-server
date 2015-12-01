package models

import play.api._
import play.api.libs.json._
import play.api.data.validation._

sealed abstract class Error(val code: Int, val message: String)

object Error {
  type JsonError = (JsPath, Seq[ValidationError])

  case class InvalidSongData(details: Seq[JsonError])
    extends Error(100, "Fip does not provide valid song data")

  case class InvalidShowData(details: Seq[JsonError])
    extends Error(200, "Fip does not provide valid show data")

  implicit val jsonErrorWrites = new JsonErrorWrites
  implicit val invalidSongDataWrites = Json.writes[InvalidSongData]
  implicit val invalidShowDataWrites = Json.writes[InvalidShowData]

  class JsonErrorWrites extends Writes[JsonError] {
    override def writes(error: JsonError): JsValue = error match {
      case (path, errors) => JsObject(Seq(
        "path" -> JsString(path.toJsonString),
        "errors" -> JsArray(errors.map(err => JsString(err.message)))
      ))
    }
  }
}
