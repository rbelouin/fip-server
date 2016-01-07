package models

import play.api._
import play.api.libs.json._
import play.api.data.validation._

sealed abstract class Error(val code: Int, val message: String, val details: Seq[Error.JsonError])


object Error {
  type JsonError = (JsPath, Seq[ValidationError])

  case class InvalidSongData(errors: Seq[JsonError])
    extends Error(100, "Fip does not provide valid song data", errors)

  case class InvalidShowData(errors: Seq[JsonError])
    extends Error(200, "Fip does not provide valid show data", errors)

  case class InvalidFipData(errors: Seq[JsonError])
    extends Error(300, "Fip does not provide valid data", errors)

  implicit val jsonErrorWrites = new JsonErrorWrites
  implicit val errorWrites = new ErrorWrites

  class JsonErrorWrites extends Writes[JsonError] {
    override def writes(error: JsonError): JsValue = error match {
      case (path, errors) => JsObject(Seq(
        "path" -> JsString(path.toJsonString),
        "errors" -> JsArray(errors.map(err => JsString(err.message)))
      ))
    }
  }

  class ErrorWrites extends Writes[Error] {
    override def writes(error: Error): JsValue = JsObject(Seq(
      "code" -> JsNumber(error.code),
      "message" -> JsString(error.message),
      "details" -> Json.toJson(error.details)
    ))
  }
}
