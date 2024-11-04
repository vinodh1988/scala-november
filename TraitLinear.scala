trait First {
    def show = println("First one")
}

trait Second extends First{
    
  override  def show = {
        super.show
        println("Second One")
    }
}

trait Third extends Second {
    override   def show = {
        super.show
        println("Third One")
    }
}

class Store extends Third
class Main extends First

@main def example = {
   val obj:First = new Main with Second
   obj.show
}
