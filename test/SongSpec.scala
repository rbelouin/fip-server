import org.specs2._
import org.specs2.matcher._

import play.api.libs.json._

import models._

class SongSpec extends Specification { def is = s2"""

  This is a specification for the Song model

  The Song.fromInput method should
    convert an SongInput instance to a Song correctly $fromInput

  The Song.parse method should
    parse FIP json correctly                          $parse
    parse FIP json correctly (no label)               $parseNoLabel
    return an error when the song field is missing    $parseNoSong
                                                      """
  def fromInput = {
    Song.fromInput(SongInput(
      "id",
      42,
      92,
      "title",
      "album",
      "artist",
      "year",
      Some("label"),
      Map("small" -> "small", "medium" -> "medium"),
      "itunes"
    )) === Song(
      "id",
      42,
      92,
      "title",
      "album",
      "artist",
      "year",
      Some("label"),
      Map("small" -> "small", "medium" -> "medium"),
      "itunes"
    )
  }

  def parse = {
    Song.parse(Data.current).asOpt === Some(Song(
      "6bf6b0d5f569da2d460de4e49cc311e0",
      1443718524,
      1443718769,
      "JE PARLE EN FOU",
      "CAP WALLER",
      "BERTRAND BELIN",
      "2015",
      Some("CINQ 7"),
      Map(
        "small" -> "http://is2.mzstatic.com/image/thumb/Music6/v4/c9/f5/e8/c9f5e84d-2e67-af7d-fad6-784547927acc/3596973270726_cover.jpg/100x100bb-85.jpg",
        "medium" -> "http://is2.mzstatic.com/image/thumb/Music6/v4/c9/f5/e8/c9f5e84d-2e67-af7d-fad6-784547927acc/3596973270726_cover.jpg/400x400bb-85.jpg"
      ),
      "https://itunes.apple.com/fr/album/je-parle-en-fou/id1038007979?i=1038008110&uo=4"
    ))
  }

  def parseNoLabel = {
    Song.parse(Data.current_no_label).asOpt === Some(Song(
      "6bf6b0d5f569da2d460de4e49cc311e0",
      1443718524,
      1443718769,
      "JE PARLE EN FOU",
      "CAP WALLER",
      "BERTRAND BELIN",
      "2015",
      None,
      Map(
        "small" -> "http://is2.mzstatic.com/image/thumb/Music6/v4/c9/f5/e8/c9f5e84d-2e67-af7d-fad6-784547927acc/3596973270726_cover.jpg/100x100bb-85.jpg",
        "medium" -> "http://is2.mzstatic.com/image/thumb/Music6/v4/c9/f5/e8/c9f5e84d-2e67-af7d-fad6-784547927acc/3596973270726_cover.jpg/400x400bb-85.jpg"
      ),
      "https://itunes.apple.com/fr/album/je-parle-en-fou/id1038007979?i=1038008110&uo=4"
    ))
  }

  def parseNoSong = {
    Song.parse(Data.current_no_song) match {
      case JsError(Seq((path, _))) => path.toJsonString === "obj.current.song"
      case result => ko(result.toString)
    }
  }
}
