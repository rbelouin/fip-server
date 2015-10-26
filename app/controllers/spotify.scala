package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.ws._

import models._

import play.api.Play.current

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class SpotifyController extends Controller {

  def login = Action.async { req =>
    val redirect_uri = req.getQueryString("redirect_uri").getOrElse("")
    val scope = req.queryString.get("scope").getOrElse(Seq.empty[String])
    val state = java.util.UUID.randomUUID.toString

    req.getQueryString("refresh_token") match {
      case Some(token) => {
        Spotify.refreshToken(req.host, token).map(o_token => {
          o_token.fold(
            InternalServerError("Invalid Token")
          )(token => {
            Redirect(redirect_uri, token.toQueryString)
          })
        })
      }
      case _ => {
        Spotify.saveRedirectionURI(state, redirect_uri)

        Future(Redirect("https://accounts.spotify.com/authorize", Map(
          "response_type" -> Seq("code"),
          "client_id" -> Seq(Spotify.clientId),
          "scope" -> Seq(scope.mkString(" ")),
          "redirect_uri" -> Seq("http://" + req.host + "/api/callback"),
          "state" -> Seq(state)
        )))
      }
    }
  }

  def callback = Action.async { req =>
    type FR = Future[Result]

    val o_code = req.getQueryString("code")
    val o_uri = for {
      state <- req.getQueryString("state")
      uri <- Spotify.getRedirectionURI(state)
    } yield uri

    o_code.fold[FR](Future(BadRequest("The code query parameter is missing")))(code => {
      o_uri.fold[FR](Future(BadRequest("Invalid State")))(uri => {
        Spotify.createToken(req.host, code).map(o_token => {
          o_token.fold[Result](
            InternalServerError("Invalid Token")
          )(token => {
            Redirect(uri, token.toQueryString)
          })
        })
      })
    })
  }

}
