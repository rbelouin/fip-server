package models

import play.api._

import scala.concurrent.duration._

object Configuration {
  import Play.current

  val conf = Play.configuration

  val actorSystemName: String = {
    conf.getString("fip.actor.system").getOrElse("")
  }

  val actorTimeout: FiniteDuration = {
    val ms = conf.getMilliseconds("fip.actor.timeout").getOrElse(10000l)
    ms.milliseconds
  }

  val defaultCover: Option[String] = {
    conf.getString("fip.default-cover")
  }

  val sources: Map[String, String] = {
    val keys = conf.getConfig("fip.sources").map(_.keys).getOrElse(Nil)

    keys.flatMap(key => {
      conf.getString("fip.sources." + key).map(value => (key, value))
    }).toMap
  }

  val oldSource: Option[String] = {
    conf.getString("fip.old-source")
  }
}
