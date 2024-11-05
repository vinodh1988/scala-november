


implicit def intToString(x: Int): String = x.toString
implicit def takeAmount(x:Double): Amount = new Amount(x)
// The compiler converts Int (42) to String using intToString
case class Amount(amt: Double)

@main def executable: Unit = {
val str: String = 42 
var int: Int = 900
var money:Amount = 500.50
println("Converted: " + str + "int "+ (int+20)) // Output: "Converted: 42"
println(money)
}

