import org.specs2.mutable._
import org.specs2.concurrent._
import org.specs2.specification.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

import play.api.libs.json._

import akka.actor._
import akka.stream._
import akka.stream.scaladsl._

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import models._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class FetcherSpec extends Specification with ExecutionEnvironment { def is(implicit ee: ExecutionEnv) = {

  implicit val system = ActorSystem("test")
  implicit val materializer = ActorMaterializer()

  "Fetcher" should {

    "fetch data every n milliseconds" in {
      var count = 0
      val source = Fetcher.source(200.milliseconds, () => {
        count = count + 1
        Future(JsNumber(count))
      })

      val elems: Future[Seq[Int]] = source.takeWithin(900.milliseconds).runWith(Sink.seq)
      elems.map(_ === Seq(1, 2, 3, 4, 5).map(JsNumber(_))).await(0, 2.seconds)
    }

  }

}
}
