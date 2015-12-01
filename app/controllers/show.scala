package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global

import models._

class ShowController extends Controller {
  import Play.current
  import Show._
  import Error._

  def getCurrentShow = Action.async {
    Fip.getCurrentShow.map(_.fold[Result](
      error => InternalServerError(Json.toJson(error)),
      show => Ok(Json.toJson(show))
    ))
  }

  def getShowsWS = WebSocket.acceptWithActor[JsValue, JsValue] {
    req => out => Fip.getShows(out)
  }
}
