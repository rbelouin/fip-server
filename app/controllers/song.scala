package controllers

import play.api._
import play.api.mvc._

import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global

import models._

class SongController extends Controller {
  def getCurrentSong = Action.async {
    SongFetcher.fetchCurrent.map(m_song => {
      m_song.fold[Result](InternalServerError)(song => {
        Ok(Json.toJson(song))
      })
    })
  }

  def getSongs = Action { req =>
    if(req.accepts("audio/mpeg")) {
      SeeOther("http://audio.scdn.arkena.com/11016/fip-midfi128.mp3")
    }
    else {
      NotAcceptable
    }
  }
}
