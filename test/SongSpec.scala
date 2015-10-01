import org.specs2._

import models._

class SongSpec extends Specification { def is = s2"""

  This is a specification for the Song model

  The Song.fromInput method should
    convert an SongInput instance to a Song correctly $fromInput

  The Song.parse method should
    parse FIP json correctly                          $parse
                                                      """
  def fromInput = {
    Song.fromInput(SongInput("az", "er", "ty", 42)) === Song("az", "er", "ty", 42)
  }

  def parse = {
    Song.parse(Data.FIP_player_current) === Some(Song(
      "6bf6b0d5f569da2d460de4e49cc311e0",
      "JE PARLE EN FOU",
      "BERTRAND BELIN",
      1443718524
    ))
  }
}
