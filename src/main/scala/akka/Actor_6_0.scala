
import akka.actor.{Props, ActorSystem, Actor}


object Actor_6_0 {

  object HelloActor {
    case object Greet
  }

  class HelloActor extends Actor {
    def receive = {
      case HelloActor.Greet => {
        println("hello world")
        context.system.shutdown()
      }
    }
  }


  def main(args: Array[String]) = {
    val system = ActorSystem("HelloSystem")
    val greeter = system.actorOf(Props[HelloActor])
    greeter ! HelloActor.Greet
  }
}
