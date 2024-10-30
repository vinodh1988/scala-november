
implicit class EnhancedInt(val x: Int) {
  def #%(discount: Int): Int = x - (x * discount / 100)
  def rangeFinder():String = {
    if(x>=0 && x <=1000)
        return "0-1000"
    else if(x>1000)
        return "1000+"
    else 
        return "negative"
  }
}

@main  def Runit = {
// Usage
val result:Int = 500 #% 20 // Adds 20% to 100
println(result) // Output: 120
println(result.rangeFinder())
}