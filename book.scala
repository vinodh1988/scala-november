case class Book(title: String, price: Double)

object Book {
  // apply method with a code block for validation
  def apply(title: String, price: Double): Book = {
    // Validate that price is non-negative
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative")
    }
    println(s"Creating a book with title: '$title' and price: $$${price}")
    new Book(title, price) // Return a new instance of Book
  }

  // unapply method for pattern matching and decomposition
  def unapply(book: Book): Option[(String, Double)] = {
    println(s"Decomposing book: '${book.title}', Price: $$${book.price}")
    Some((book.title, book.price))
  }
}
@main def runit = {
// Using apply with code block
try {
  val book = Book("Scala Programming", 39.99)  // Valid input
  val invalidBook = Book("Free Book", -5.0)     // This will throw an exception
} catch {
  case e: IllegalArgumentException => println(e.getMessage)
}

// Using unapply for pattern matching
val book = Book("Functional Programming in Scala", 49.99)
book match {
  case Book(title, price) => println(s"Matched book: Title = '$title', Price = $$${price}")
  case _ => println("Not a book")
}
}