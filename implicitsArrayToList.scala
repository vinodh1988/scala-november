// Step 1: Define the Student case class
case class Student(sno: Int, name: String, score: Int)

class ArrayWrapper[T](val array: Array[T]) extends AnyVal

// Step 2: Define implicit conversions
object ImplicitConversions {
  // Convert a tuple (Int, String, Int) to a Student
  implicit def tupleToStudent(tuple: (Int, String, Int)): Student = 
    Student(tuple._1, tuple._2, tuple._3)
  
  implicit def arrayToList[T](array: Array[T]): List[T] = {
    def convert(index: Int, acc: List[T]): List[T] = {
      if (index < 0) acc       // Base case: return accumulated list when index is out of bounds
      else convert(index - 1, array(index) :: acc)  // Prepend element at current index and decrement
    }
    convert(array.length - 1, Nil)  // Start converting from the last element to the first
  }
}


// Step 3: Example usage
object Main extends App {
  import ImplicitConversions._
  
  // Using tuple to Student conversion
  val student: Student = (1, "Alice", 85)  // Implicitly converted to Student
  println(student)

  // Using Array[Student] to List[Student] conversion
  val studentArray: Array[Student] = Array(
  (1, "Alice", 85), (2, "Bob", 92), (3, "Charlie", 78), (4, "David", 66), (5, "Eve", 90),
  (6, "Frank", 73), (7, "Grace", 88), (8, "Hannah", 91), (9, "Isaac", 84), (10, "Judy", 76),
  (11, "Kevin", 82), (12, "Laura", 79), (13, "Mike", 95), (14, "Nina", 70), (15, "Oscar", 89),
  (16, "Paul", 80), (17, "Quinn", 77), (18, "Rachel", 93), (19, "Sam", 85), (20, "Tina", 74),
  (21, "Uma", 69), (22, "Victor", 96), (23, "Wendy", 87), (24, "Xander", 68), (25, "Yara", 94),
  (26, "Zane", 81), (27, "Oliver", 78), (28, "Sophia", 85), (29, "Liam", 90), (30, "Mia", 83),
  (31, "Noah", 88), (32, "Emma", 75), (33, "Ava", 92), (34, "William", 86), (35, "James", 91),
  (36, "Lucas", 72), (37, "Amelia", 79), (38, "Ella", 89), (39, "Mason", 76), (40, "Logan", 95),
  (41, "Ethan", 84), (42, "Charlotte", 82), (43, "Benjamin", 80), (44, "Alexander", 71),
  (45, "Michael", 88), (46, "Isabella", 73), (47, "Daniel", 86), (48, "Elijah", 81),
  (49, "Matthew", 79), (50, "Jackson", 92)
)


  val studentList: List[Student] = studentArray  // Implicitly converted to List[Student]
  println(studentList)
}
