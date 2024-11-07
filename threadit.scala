import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Random, Success}

object Task7 {

  @volatile var stopThreads = false

  def randomNumberThreadExecutor: Future[String] = {
    val promise = Promise[String]
    val future = promise.future

    val firstThread = new Thread(() => {
      while (!stopThreads) {
        Thread.sleep(1)
        val randomNumber = Random.nextInt(10000)
        if (randomNumber == 1567 && !promise.isCompleted) {
          promise.success("firstThread has generated 1567")
          stopThreads = true
        }
      }
    })

    val secondThread = new Thread(() => {
      while (!stopThreads) {
        Thread.sleep(1)
        val randomNumber = Random.nextInt(10000)
        if (randomNumber == 1567 && !promise.isCompleted) {
          promise.success("secondThread has generated 1567")
          stopThreads = true
        }
      }
    })

    val thirdThread = new Thread(() => {
      while (!stopThreads) {
        Thread.sleep(1)
        val randomNumber = Random.nextInt(10000)
        if (randomNumber == 1567 && !promise.isCompleted) {
          promise.success("thirdThread has generated 1567")
          stopThreads = true
        }
      }
    })

    firstThread.start()
    secondThread.start()
    thirdThread.start()

    future
  }

  def main(args: Array[String]): Unit = {
    val result = randomNumberThreadExecutor
    //    Await.result(result, Duration.Inf)
//    println(result)
    result.onComplete {
      case Success(value) => println(value)
      case Failure(exception) => println(exception)
    }
//    println("Main thread is Ended")
    //    println(result.value.get.get)
  }
}