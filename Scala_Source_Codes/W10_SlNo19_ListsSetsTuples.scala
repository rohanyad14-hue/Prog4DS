// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 19: Collections in Scala: Lists, Sets, and Tuples
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 10 | Sl. No: 19 | Type: EP | Date: 17-09-2026
// =============================================================================

// Program 19: Collections in Scala: Lists, Sets, and Tuples
// Student: Rohan Yadav | Reg. No: 26MML0020

object Experiment19_ListsSetsTuples {
  def main(args: Array[String]): Unit = {
    // 1. Prime List & Functional Squaring
    val primes: List[Int] = List(2, 3, 5, 7, 11)

    def squareList(lst: List[Int]): List[Int] = {
      lst.map(x => x * x)
    }

    println(s"Original primes: $primes")
    println(s"Squared primes:  ${squareList(primes)}")

    // 2. Set of Unique Characters & Set Intersection
    val charSet1: Set[Char] = "hello world".toSet
    val charSet2: Set[Char] = "world wide web".toSet

    def setIntersection[T](s1: Set[T], s2: Set[T]): Set[T] = {
      s1 & s2
    }

    println(s"Unique chars in 'hello world': $charSet1")
    println(s"Intersection with 'world wide web': ${setIntersection(charSet1, charSet2)}")

    // 3. Heterogeneous 3-Element Tuple Creation and Access
    val studentRecord: (Int, String, Boolean) = (260020, "Rohan Yadav", true)

    println("=== 3-Element Heterogeneous Tuple Access ===")
    println(s"Field 1 (_1 - Student RegID): ${studentRecord._1} [Type: Int]")
    println(s"Field 2 (_2 - Student Name):  ${studentRecord._2} [Type: String]")
    println(s"Field 3 (_3 - Status Active): ${studentRecord._3} [Type: Boolean]")
    println("Tuple arity: 3 elements accessed safely.")
  }
}
