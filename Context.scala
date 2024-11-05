object Extensions {
  implicit class StringExtensions(val str: String) {
    def isPalindrome: Boolean = str == str.reverse
  }
}

// Usage with import
object AppWithExtensions extends App {
  import Extensions.StringExtensions // Extension method is available
  println("madam".isPalindrome) // Output: true
}

// Usage without import
object AppWithoutExtensions extends App {
  // No import here, so `isPalindrome` is not available
  // println("madam".isPalindrome) // This would cause a compilation error
}
