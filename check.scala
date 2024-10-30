def multiplyByTwo(x: Int): Int = x * 2
def addOne(x: Int): Int = x + 1


@main def check= {


val multiplyAndAddOne = (multiplyByTwo).andThen(addOne)
println(multiplyAndAddOne(3)) // Output: 7

}