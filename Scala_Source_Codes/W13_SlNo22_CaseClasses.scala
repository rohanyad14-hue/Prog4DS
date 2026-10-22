// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 22: Case Classes and Data Modeling in Scala
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 13 | Sl. No: 22 | Type: EP | Date: 15-10-2026
// =============================================================================

// Program 22: Case Classes and Data Modeling in Scala
// Student: Rohan Yadav | Reg. No: 26MML0020

case class Person(name: String, age: Int, city: String)

object Experiment22_CaseClasses {
  def main(args: Array[String]): Unit = {
    val people = List(
      Person("Vedant Nimkar", 24, "Mumbai"),
      Person("Ayush Sharma", 32, "Delhi"),
      Person("Rohan Yadav", 28, "Bengaluru"),
      Person("Priya Patel", 35, "Mumbai"),
      Person("Sneha Reddy", 22, "Hyderabad")
    )

    // 1. Filter out people older than 30
    val olderThan30 = people.filter(_.age > 30)
    println("1. People Older than 30:")
    olderThan30.foreach(p => println(s"   - ${p.name} (Age: ${p.age})"))

    // 2. Group people by city
    val groupedByCity = people.groupBy(_.city)
    println("\n2. Grouped by City:")
    groupedByCity.foreach {
      case (city, group) => println(s"   - $city: ${group.map(_.name).mkString(", ")}")
    }

    // 3. Transform each Person into formatted description string
    val formattedStrings = people.map(p => s"${p.name} is ${p.age} years old and lives in ${p.city}")
    println("=== Person String Transformation and Age-Based Sorting ===")
    println("1. Formatted Description Strings:")
    formattedStrings.foreach(s => println(s"   - $s"))

    // 4. Sort people by age in ascending order
    val sortedByAge = people.sortBy(_.age)
    println("\n2. Sorted by Age in Ascending Order:")
    sortedByAge.zipWithIndex.foreach {
      case (p, idx) => println(s"   [Rank ${idx + 1}] ${p.name} (Age ${p.age}, ${p.city})")
    }
  }
}
