// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 21: Advanced Functional Combinators in Scala
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 12 | Sl. No: 21 | Type: EP | Date: 08-10-2026
// =============================================================================

// Program 21: Advanced Functional Combinators in Scala
// Student: Rohan Yadav | Reg. No: 26MML0020

object Experiment21_Combinators {
  def main(args: Array[String]): Unit = {
    val nums: List[Int] = (1 to 10).toList
    println(s"Initial Integer List: $nums")

    // 1. Filter: Extract even numbers
    val evens = nums.filter(x => x % 2 == 0)
    println(s"1. Even Numbers (filter):\n   $evens")

    // 2. Map: Multiply each element by 3
    val tripled = nums.map(x => x * 3)
    println(s"2. Elements Multiplied by 3 (map):\n   $tripled")

    // 3. FlatMap: Pair each integer with its square as tuples
    val pairedWithSquare = nums.flatMap(x => List((x, x * x)))
    println(s"3. Paired with Square as Tuples (flatMap):\n   $pairedWithSquare")

    // 4. FoldLeft: Calculate product of all elements (Factorial of 10)
    val totalProduct = nums.foldLeft(1)((acc, elem) => acc * elem)
    println("=== FoldLeft Product Accumulator Computation ===")
    println(s"Input List: $nums")
    println("Accumulator initial value: 1")
    println("Reduction formula: foldLeft(1)((acc, x) => acc * x)")
    println(s"Final Accumulated Product (10!): $totalProduct")
  }
}
