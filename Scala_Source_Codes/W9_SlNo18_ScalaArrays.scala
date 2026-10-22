// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 18: Arrays and Array Operations in Scala
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 09 | Sl. No: 18 | Type: EP | Date: 10-09-2026
// =============================================================================

// Program 18: Arrays and Array Operations in Scala
// Student: Rohan Yadav | Reg. No: 26MML0020

object Experiment18_Arrays {
  def main(args: Array[String]): Unit = {
    // 1. Array of integers with specified values
    val intArr: Array[Int] = Array(2, 5, 9, 14, 20)

    // Pure function to calculate array sum
    def sumArray(arr: Array[Int]): Int = {
      arr.sum
    }

    val totalSum = sumArray(intArr)
    println(s"Sum of integer array elements: $totalSum")

    // 2. Array of strings containing five fruit names
    val fruitArr: Array[String] = Array("Apple", "Banana", "Cherry", "Date", "Elderberry")

    // Pure function to concatenate strings separated by commas
    def concatenateFruits(arr: Array[String]): String = {
      arr.mkString(", ")
    }

    val fruitString = concatenateFruits(fruitArr)
    println(s"Concatenated fruits: $fruitString")

    // 3. Higher-order iteration over integer array using foreach
    println("Iterating over integer array (foreach):")
    intArr.zipWithIndex.foreach { case (elem, idx) =>
      println(s"Element at index $idx: $elem")
    }
    println(s"Total elements iterated: ${intArr.length}")
    println("Array traversal completed successfully.")
  }
}
