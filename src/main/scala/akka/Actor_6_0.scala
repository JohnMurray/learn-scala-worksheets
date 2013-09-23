package akka

import akka.actor.{Props, ActorSystem, Actor}


class Actor_6_0 extends App {

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
