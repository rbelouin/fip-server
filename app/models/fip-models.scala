package models.fip

import play.api.libs.json._

import models.Song
import models.Show

case class FipStep(
  // _version may be the version of the model
  _version: Option[Int] = None,

  // stepId may be a "broadcasting" id,
  // if the song is played later, it may have a different stepId
  stepId: Option[String] = None,

  // ID of the song/show
  uuid: Option[String] = None,

  // Title of the song/show
  title: Option[String] = None,

  // Timestamp (Europe/Paris) of the start of the step's broadcast
  start: Option[Long] = None,

  // Timestamp (Europe/Paris) of the end of the step's broadcast
  end: Option[Long] = None,

  // Seems to be the ID of the show step for a song
  fatherStepId: Option[String] = None,

  // ID of the station (7 for the radio, 65 for the jazz station…)
  stationId: Option[Int] = None,

  // ???
  embedId: Option[String] = None,

  // embedType is "song" for a song and seems to be "blank" for a show
  embedType: Option[String] = None,

  // ???
  depth: Option[Int] = None,

  // Artists
  authors: Option[String] = None,

  // Title of the song/show, in a specific format
  titleSlug: Option[String] = None,

  // Cover of the album or a logo
  visual: Option[String] = None,

  // Itunes link
  path: Option[String] = None,

  // Youtube link
  lienYoutube: Option[String] = None,

  // Youtube preview
  visuelYoutube: Option[String] = None,

  // Label of the album
  label: Option[String] = None,

  // Year of the album release
  anneeEditionMusique: Option[Int] = None,

  // Name of the album
  titreAlbum: Option[String] = None
)

case class FipLevel(
  items: Seq[String],
  position: Int
)

case class FipInfo(
  steps: Map[String, FipStep],
  levels: Seq[FipLevel],
  stationId: Int
)

object Fip {
  implicit val FipStepFormat = Json.format[FipStep]
  implicit val FipLevelFormat = Json.format[FipLevel]
  implicit val FipInfoFormat = Json.format[FipInfo]

  def fromJson(json: JsValue): JsResult[FipInfo] = {
    Json.fromJson[FipInfo](json)
  }

  def getCurrentSong(info: FipInfo): Option[Song] = for {
    songLevel <- info.levels.lastOption
    songItem  <- songLevel.items.lift(songLevel.position)
    step      <- info.steps.get(songItem)
    id        <- step.uuid
    startTime <- step.start
    endTime   <- step.end
    title     <- step.title
    album     <- step.titreAlbum
    artist    <- step.authors
  } yield Song(
    id=id,
    startTime=startTime,
    endTime=endTime,
    title=title,
    album=album,
    artist=artist,
    year=step.anneeEditionMusique.map(_.toString),
    label=step.label,
    icons=step.visual.fold(Map.empty[String,String])(v => Map("medium" -> v)),
    itunes=step.path.getOrElse("")
  )

  def getCurrentShow(info: FipInfo): Option[Show] = for {
    showLevel <- info.levels.headOption if info.levels.size == 2
    showItem  <- showLevel.items.lift(showLevel.position)
    step      <- info.steps.get(showItem)
    id        <- step.uuid
    startTime <- step.start
    endTime   <- step.end
    name      <- step.title
  } yield Show(
    id=id,
    startTime=startTime,
    endTime=endTime,
    name=name,
    icons=step.visual.fold(Map.empty[String,String])(v => Map("medium" -> v))
  )
}
