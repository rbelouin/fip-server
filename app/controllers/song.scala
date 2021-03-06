package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global

import models._

class SongController extends Controller {
  import Play.current
  import Song._
  import Error._

  def getCurrentSong = Action.async {
    Fip.getCurrentSong.map(_.fold[Result](
      error => InternalServerError(Json.toJson(error)),
      song => Ok(Json.toJson(song))
    ))
  }

  def getSongs = Action { req =>
    if(req.accepts("audio/mpeg")) {
      SeeOther("http://audio.scdn.arkena.com/11016/fip-midfi128.mp3")
    }
    else {
      NotAcceptable
    }
  }

  def getSongsWS = WebSocket.acceptWithActor[JsValue, JsValue] {
    req => out => Fip.getSongs(out)
  }
}
