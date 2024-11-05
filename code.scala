def multipart(name:String)(logic: =>Unit): Unit = {
      println(s"Hi $name")
      logic //not going to do anything
      
    
}

@main def funccall() = {
    {
        println("Block Here")
    }

    val x:Unit= { println(2+3)}  //During assignement evaluate, not reausable
    println(x) //it is not callable

   /* multipart("Store")({
       println(2+3)
    })*/
/* 
    Block executes on spot
    a Function block executes only upon call

 */


}
