
import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}
object AsyncAwait {

  def main(args: Array[String]): Unit = {

    // Function simulating an asynchronous operation
    def performAsyncOperation(): Future[Int] = {
      val promise = Promise[Int]()

      // Simulating an asynchronous computation
      val thread = new Thread(new Runnable {
        def run(): Unit = {
          Thread.sleep(1000) // Simulating some processing time
          val result = 42
          promise.success(result) 

    // Fulfilling the promise with a result
        }
      })

      thread.start() // thread might get the chance to run as it stated itself as ready

      promise.future // Returning the future associated with the promise
    }

    // Using the asynchronous operation
    val futureResult: Future[Int] = performAsyncOperation()

    // Handling the result of the future
    futureResult.onComplete {
      case Success(result) => println(s"Async operation completed successfully with result: $result")
      case Failure(exception) => println(s"Async operation failed with exception: $exception")
    }
    Thread.sleep(15000)
  }


}
