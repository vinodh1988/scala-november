
def roomAvailability(x: Int):Either[String,Int] = {
      if(x<15)
         Right(2)
      else 
        Left("No Rooms are available")
}

object RunEither extends App {
roomAvailability(10) match {
  case Right(value) => println(s"Available: $value")
  case Left(error) => println(s"Result: $error")
}

}

