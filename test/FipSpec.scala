import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

import play.api.libs.json._

import models.Song
import models.Show
import models.fip._
import test.data._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class SongSpec extends Specification {

  "Fip" should {

    "parse valid Fip data" in {
      val json = Json.parse(FipData.stringified1)
      val result = Fip.fromJson(json)

      result === JsSuccess(FipData.parsed1)
    }

    "parse valid Fip data (containing some show info)" in {
      val json = Json.parse(FipData.stringified2)
      val result = Fip.fromJson(json)

      result === JsSuccess(FipData.parsed2)
    }

    "extract the song being played from Fip data" in {
      Fip.getCurrentSong(FipData.parsed1) === Some(FipData.currentSong1)
    }

    "extract the song being played from Fip data (containing some show info)" in {
      Fip.getCurrentSong(FipData.parsed2) === Some(FipData.currentSong2)
    }

    "extract the show being broadcasted from Fip data" in {
      Fip.getCurrentShow(FipData.parsed1) === None
    }

    "extract the show being broadcasted from Fip data (containing some show info)" in {
      Fip.getCurrentShow(FipData.parsed2) === Some(FipData.currentShow2)
    }

  }
}
