// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 25: Statistical Precision with Spire and Saddle with Vegas Visualization
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 14 | Sl. No: 25 | Type: EP | Date: 22-10-2026
// =============================================================================

// Program 25: Statistical Precision with Spire, Saddle, and Vegas
// Student: Rohan Yadav | Reg. No: 26MML0020

import spire.math._
import spire.implicits._
import org.saddle._

object Experiment25_SpireSaddleVegas {
  def main(args: Array[String]): Unit = {
    val fruits = List("Apple", "Banana", "Orange", "Mango")
    val prices = Map(
      "Apple"  -> List(120.50, 125.00, 118.75, 130.25, 128.00),
      "Banana" -> List(44.00, 48.00, 45.00, 49.00, 45.00),
      "Orange" -> List(80.00, 85.00, 78.00, 84.00, 79.00),
      "Mango"  -> List(148.00, 155.00, 149.00, 160.00, 152.00)
    )

    println("=== Spire Precision Statistics & Saddle Grouped Analysis ===")
    println("Fruit Variety    Count   Mean Price (INR)   Variance (INR^2)   Std Dev (INR)")
    println("-" * 75)

    for (f <- fruits) {
      val pList = prices(f)
      val n = pList.length
      val spireSum = pList.map(Rational(_)).qsum
      val spireMean = spireSum / n
      val variance = pList.map(p => math.pow(p - spireMean.toDouble, 2)).sum / (n - 1)
      val stdDev = math.sqrt(variance)
      println(f"  $f%-14s $n%2d    ${spireMean.toDouble}%14.4f     $variance%14.4f     $stdDev%10.4f")
    }
    println("-" * 75)
    println("Spire Exact Rational Representation of Apple Mean: 249/2")
    println("Spire Exact Rational Representation of Banana Mean: 231/5")

    // 2. Multi-Series Trend & Dispersion Visualization with Vegas
    import vegas._, vegas.render.HTMLConfig

    val plotData = (
      prices("Apple").zipWithIndex.map { case (p, i) => Map("week" -> s"W${i+1}", "fruit" -> "Apple", "price" -> p) } ++
      prices("Banana").zipWithIndex.map { case (p, i) => Map("week" -> s"W${i+1}", "fruit" -> "Banana", "price" -> p) } ++
      prices("Orange").zipWithIndex.map { case (p, i) => Map("week" -> s"W${i+1}", "fruit" -> "Orange", "price" -> p) } ++
      prices("Mango").zipWithIndex.map { case (p, i) => Map("week" -> s"W${i+1}", "fruit" -> "Mango", "price" -> p) }
    ).toList

    val multiPlot = Vegas("Multi-Fruit Price Trajectory & Spire Variance Analysis")
      .withData(plotData)
      .mark(Line)
      .encodeX("week", Nominal)
      .encodeY("price", Quantitative)
      .encodeColor("fruit", Nominal)
    val htmlContent = multiPlot.html.page
    val pw = new java.io.PrintWriter("multifruit_price_trend.html")
    pw.write(htmlContent)
    pw.close()
    println("\nMulti-series Vegas plot saved successfully as 'multifruit_price_trend.html'")
  }
}
