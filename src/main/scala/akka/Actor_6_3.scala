import akka.actor.{Props, ActorSystem, Actor}

/*
 * A few things to notice:
 *   - "remote" actor lookup in Local Worker
 */
object Actor_6_3 {

  class LocalWorker extends Actor {
    val remoteActor = context.actorSelection("akka://my-system/user/remote")
  //val remoteActor = context.actorSelection("akka.tcp://my-system@host:port/user/remote")

    def receive = {
      case LocalWorker.Greet => {
        remoteActor ! "Hello"
      }
    }
  }
  object LocalWorker {
    case object Greet
  }

  class RemoteWorker extends Actor {
    def receive = {
      case msg: String => {
        println("received message %s".format(msg))
        context.system.shutdown()
      }
    }
  }

  def main(args: Array[String]) = {
    val system = ActorSystem("my-system")

    val remoteWorker = system.actorOf(Props[RemoteWorker], name="remote")
    val localWorker = system.actorOf(Props[LocalWorker])

    localWorker ! LocalWorker.Greet
  }

}
