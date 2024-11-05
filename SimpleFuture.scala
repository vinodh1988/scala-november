import scala.util.{Success,Failure}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def provideMeData():Future[String] = {
  Future {
    println("Making the resource Ready")
    //Thread.sleep(5000)
    println("Printing it.......")

    println("Longer")
    "Resource is Ready"
  }
}

@main def caller() = {
    provideMeData().onComplete{
        case Success(value) => println("Received ::"+value)
        case Failure(exception) =>  println(exception.getMessage())
    }
 
        println("Something Else")
        println("Going to Wait for 50 seconds")
        Thread.sleep(50000)
}