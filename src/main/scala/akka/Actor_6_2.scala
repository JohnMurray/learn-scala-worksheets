import akka.actor._
import akka.actor.SupervisorStrategy.{Resume}
import akka.routing.{RoundRobinRouter}
import scala.compat.Platform
import scala.util.Random

/*
 * A few things to notice:
 *   - RandomException object
 *   - non-deterministic failure in Worker and Listener
 *   - supervisor strategy in Master
 *   - implicit actor restart of Listener
 */
object Actor_6_2 {

  case class Job(name: String)
  case class Result(greeting: String)
  case class BatchResult(results: List[String])

  object RandomException {
    private val randomGenerator = new Random(Platform.currentTime)
    def apply(percent: Int) = {
      val randomNumber = randomGenerator.nextInt(100)
      if (randomNumber < percent) {
        throw new Exception("Rando Exception failure")
      }
    }
  }

  class MasterGreeter(val listener: ActorRef, val batchSize: Int)
    extends Actor {

    val workerRouter = context.actorOf(
      Props[Worker].withRouter(RoundRobinRouter(4)), name="workerRouter")

    override val supervisorStrategy = OneForOneStrategy() {
      case _: Exception => {
        println("Exception occurred in worker")

        /* Stop */
        /* Restart */
        /* Escalate */
        Resume
      }
    }

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
        RandomException(25)
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
      case name: String => {
        RandomException(50)
        sender ! Result("Hello " + name)
      }
    }
  }

  def main(args: Array[String]) = {
    val initPeople = List("Bob", "Sue", "Joe", "Gary", "Sally", "Karen")
    val people = initPeople ++ initPeople ++ initPeople ++ initPeople

    val system = ActorSystem("DistributedHelloWorldSystem")
    val listener = system.actorOf(Props(new Listener(people.length)))
    val master = system.actorOf(Props(new MasterGreeter(listener, 2)))

    people foreach(person => {
      master ! Job(person)
    })
  }

}
