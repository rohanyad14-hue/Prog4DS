// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 20: Handling Collisions and Resolving Conflicts in HashMaps
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 11 | Sl. No: 20 | Type: EP | Date: 24-09-2026
// =============================================================================

// Program 20: HashMaps and Conflict Resolution in Scala
// Student: Rohan Yadav | Reg. No: 26MML0020

import scala.collection.mutable

object Experiment20_HashMaps {
  def main(args: Array[String]): Unit = {
    // 1. Merge two HashMaps resolving conflicts by taking higher grade
    val map1 = Map("Rohan" -> 92, "Vedant" -> 88, "Ayush" -> 78, "Priya" -> 84)
    val map2 = Map("Rohan" -> 85, "Vedant" -> 95, "Kalyan" -> 90, "Priya" -> 89)

    def mergeResolveMax(m1: Map[String, Int], m2: Map[String, Int]): Map[String, Int] = {
      (m1.keySet ++ m2.keySet).map { k =>
        val grade1 = m1.getOrElse(k, 0)
        val grade2 = m2.getOrElse(k, 0)
        k -> Math.max(grade1, grade2)
      }.toMap
    }

    val merged = mergeResolveMax(map1, map2)
    println("=== Student Grades HashMap Merge with Conflict Resolution ===")
    println(s"HashMap 1 (Original Grades): $map1")
    println(s"HashMap 2 (Updated / Re-eval): $map2")
    println("Merged HashMap (Higher Grade Selected):")
    merged.toSeq.sortBy(_._1).foreach { case (k, v) => println(s"  - $k -> $v") }

    // 2. Collision Chaining via Multimap (List of values per key)
    val multiGradeMap = mutable.Map[String, List[Int]]()

    def insertChained(name: String, grade: Int): Unit = {
      val existing = multiGradeMap.getOrElse(name, Nil)
      multiGradeMap(name) = existing :+ grade
    }

    println("\n=== Chained Collision Resolution Multimap (List Chaining) ===")
    insertChained("Vedant", 88)
    insertChained("Vedant", 95) // Duplicate key appended to chain
    insertChained("Rohan", 92)
    insertChained("Rohan", 85)  // Duplicate key appended to chain
    insertChained("Ayush", 78)

    println("Final Chained Multimap Contents:")
    multiGradeMap.toSeq.sortBy(_._1).foreach {
      case (k, v) => println(s"  - $k : ${v.mkString("[", ", ", "]")}")
    }
  }
}
