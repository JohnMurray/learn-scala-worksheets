
import akka.actor.{ActorRef, Props, ActorSystem, Actor}
import akka.routing.RoundRobinRouter

/*
 * A few things to notice:
 *   - State managed within each actor
  *  - Workers and Routers
 */
object Actor_6_1 {

  case class Job(name: String)
  case class Result(greeting: String)
  case class BatchResult(results: List[String])

  class MasterGreeter(val listener: ActorRef, val batchSize: Int) extends Actor {

    val workerRouter = context.actorOf(
      Props[Worker].withRouter(RoundRobinRouter(4)), name="workerRouter")

    var resultSet : List[String] = List()

    def receive = {
      case Job(name) => workerRouter ! name
      case Result(greeting) => {
        resultSet = greeting :: resultSet
        if (resultSet.length == batchSize) {
          listener ! BatchResult(resultSet)
          resultSet = List()
        }
      }
    }
  }

  class Listener(val totalResults: Int) extends Actor {
    var currentResultCount = 0

    def receive = {
      case BatchResult(results) => {
        results foreach println
        currentResultCount += results.length
        if (currentResultCount >= totalResults) {
          context.system.shutdown()
        }
      }
    }
  }

  class Worker extends Actor {
    def receive = {
      case name: String => sender ! Result("Hello " + name)
    }
  }

  def main(args: Array[String]) = {
    val people = List("Bob", "Sue", "Joe", "Gary", "Sally", "Karen")

    val system = ActorSystem("DistributedHelloWorldSystem")
    val listener = system.actorOf(Props(new Listener(people.length)))
    val master = system.actorOf(Props(new MasterGreeter(listener, 2)))

    people foreach(person => {
      master ! Job(person)
    })
  }

}
