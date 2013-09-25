/*
 * A few things to notice:
 *   - Futures are new to 2.10 (scala + akka + twitter)
 *   - Requires execution context
 *   - Run in console (not in worksheet)
 */
object Future_5_0 {
  import scala.concurrent._
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.compat.Platform
  import scalaj.http.Http

  def race() = {
    val startTime = Platform.currentTime

    val google = future { Http("http://www.google.com").asString }
    val bing   = future { Http("http://www.bing.com").asString }
    val yahoo  = future { Http("http://yahoo.com").asString }

    google onComplete(res => println("done with google in %dms".format(Platform.currentTime - startTime)))
    bing onComplete(res => println("done with bing in %dms".format(Platform.currentTime - startTime)))
    yahoo onComplete(res => println("done with yahoo in %dms".format(Platform.currentTime - startTime)))

    println("done with method in %dms".format(Platform.currentTime - startTime))
  }

  def main(args: Array[String]) = {
    race()
  }
}
