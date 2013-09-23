/*
 * Warning:
 *  The following code does not play to well with the Worksheets for
 *  various reasons. The following code is really just to stare at
 *  (in wonder ans awe, preferably).
 */


/*
 * A few things to notice:
 *   - case objects
 *   - actor system
 */
import akka.actor.{ActorSystem, Actor, Props}

object _6_0_Actors extends App {

  object HelloActor {
    case object Greet
  }

  class HelloActor extends Actor {
    def receive = {
      case HelloActor.Greet => println("hello world")
    }
  }


  val system = ActorSystem("HelloSystem")
  val greeter = system.actorOf(Props[HelloActor])
  greeter ! HelloActor.Greet
}