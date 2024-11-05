// Define the Person case class
case class Candidate(name: String, age: Int)

// Companion object for the Candidate class
object Candidate {
  // apply method for creating a Candidate instance
  def apply(name: String, age: Int): Candidate = new Candidate(name, age)

  // unapply method for pattern matching and decomposition
  def unapply(person: Candidate): Option[(String, Int)] = Some((person.name, person.age))
}

@main def perform23():Unit = {
// Using apply to create a Person instance
val person = Candidate("Alice", 28)  // Calls apply and creates Person("Alice", 28)

// Using unapply for pattern matching
person match {
  case Candidate(name, age) => println(s"Name: $name, Age: $age")
  case _ => println("Not a person")
}
}