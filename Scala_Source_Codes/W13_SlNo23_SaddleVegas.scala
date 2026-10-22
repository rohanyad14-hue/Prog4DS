// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 23: Data Manipulation with Saddle and Vegas Interactive Visualization
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 13 | Sl. No: 23 | Type: EP | Date: 15-10-2026
// =============================================================================

// Program 23: Data Manipulation with Saddle and Vegas Visualization
// Student: Rohan Yadav | Reg. No: 26MML0020

import org.saddle._
import org.saddle.stats.SeriesStats

object Experiment23_SaddleVegas {
  def main(args: Array[String]): Unit = {
    // 1. Construct Saddle Frame with Fruit Transaction Data
    val dates = Vec("2026-05-01", "2026-05-08", "2026-05-15", "2026-05-22", "2026-05-29")
    val fruits = Vec("Apple", "Apple", "Apple", "Apple", "Apple")
    val prices = Vec(120.50, 125.00, 118.75, 130.25, 128.00)
    val quantities = Vec(45, 50, 42, 55, 48)

    val applePriceSeries = Series(dates.toIndex, prices)
    val avgPrice = applePriceSeries.mean

    println("=== Saddle Data Manipulation: Fruit Dataset Summary ===")
    println("Filtering for Fruit == \"Apple\":")
    println("  Date         Fruit   Price(INR)  Quantity(kg)")
    for (i <- 0 until dates.length) {
      println(f"  ${dates(i)}   ${fruits(i)}%-7s ${prices(i)}%6.2f      ${quantities(i)}%2d")
    }
    println(f"\nAverage Price of Apples: INR $avgPrice%.2f")

    // 2. Declarative Time-Series Visualization with Vegas
    import vegas._
    import vegas.render.HTMLConfig

    val plotData = dates.toArray.zip(prices.toArray).map { case (d, p) =>
      Map("date" -> d, "price" -> p)
    }.toList

    val plot = Vegas("Apple Price Trend Over Time")
      .withData(plotData)
      .mark(Line)
      .encodeX("date", Temporal)
      .encodeY("price", Quantitative)
    val htmlContent = plot.html.page
    val pw = new java.io.PrintWriter("apple_price_trend.html")
    pw.write(htmlContent)
    pw.close()
    println("\nPlot saved successfully as 'apple_price_trend.html'")
  }
}
