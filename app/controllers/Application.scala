package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global

import models._

class Application extends Controller {
  import Play.current

  def get = Action.async {
    Fip.getSourcesData.map(FipData.rewriteJson _).map(Ok(_))
  }

  def getWS = WebSocket.acceptWithActor[JsValue, JsValue] {
    req => out => Fip.getAll(out)
  }
}
