package models

import play.api.libs.json._
import play.api.libs.ws._

import play.api.Play.current

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

case class SpotifyToken(
  access_token: String,
  refresh_token: Option[String],
  expires_in: Long,
  token_type: String
) {
  def toQueryString = Map(
    "access_token" -> Seq(access_token),
    "refresh_token" -> refresh_token.toSeq,
    "expires_in" -> Seq(expires_in.toString),
    "token_type" -> Seq(token_type)
  )
}

object SpotifyToken {
  implicit val stf = Json.format[SpotifyToken]
}

object Spotify {
  import SpotifyToken._

  val clientId = "f65e7f23121e4322a69eab9cffa03dfb"
  val clientSecret = "96fe87c9fce3430181566c0813e068a3"
  val authorization = "Basic " + new String(java.util.Base64.getEncoder().encode((clientId + ":" + clientSecret).getBytes("UTF8")))

  private var uris = Map.empty[String, String]
  
  def saveRedirectionURI(state: String, uri: String): Unit = {
    uris = uris + (state -> uri)
  }

  def getRedirectionURI(state: String): Option[String] = {
    uris.get(state)
  }

  def createToken(host: String, code: String): Future[Option[SpotifyToken]] = {
    WS.url("https://accounts.spotify.com/api/token")
      .withHeaders(
        "Authorization" -> authorization,
        "Accept" -> "application/json",
        "Content-Type" -> "application/x-www-form-urlencoded"
      )
      .post(Map(
        "grant_type" -> Seq("authorization_code"),
        "code" -> Seq(code),
        "redirect_uri" -> Seq("http://" + host + "/api/callback")
      ))
      .map(_.json.asOpt[SpotifyToken])
  }

  def refreshToken(host: String, refresh_token: String): Future[Option[SpotifyToken]] = {
    WS.url("https://accounts.spotify.com/api/token")
      .withHeaders(
        "Authorization" -> authorization,
        "Accept" -> "application/json",
        "Content-Type" -> "application/x-www-form-urlencoded"
      )
      .post(Map(
        "grant_type" -> Seq("refresh_token"),
        "refresh_token" -> Seq(refresh_token)
      ))
      .map(res => {
        println(res.json.validate[SpotifyToken])
        res.json.asOpt[SpotifyToken]
      })
  }
}
