def multipart(name:String)(logic: =>Unit): Unit = {
      println(s"Hi $name")
      logic
      
    
}

@main def funccall() = {
multipart("India"){
   println("I am going to do some post processing here")
}
}