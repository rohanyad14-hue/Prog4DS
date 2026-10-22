// =============================================================================
// Course: Programming for Data Science (MACSE502)
// Program 24: Numerical Computations with Breeze and Plotly.Scala Visualizations
// Student: ROHAN YADAV | Reg. No: 26MML0020
// Week: 14 | Sl. No: 24 | Type: EP | Date: 22-10-2026
// =============================================================================

// Program 24: Numerical Computing with Breeze and Plotly.Scala
// Student: Rohan Yadav | Reg. No: 26MML0020

import breeze.linalg._
import breeze.stats._

object Experiment24_BreezePlotly {
  def main(args: Array[String]): Unit = {
    val fruits = Array("Apple", "Banana", "Orange", "Mango", "Grape")

    // Breeze DenseVectors for Price and Quantity
    val prices = DenseVector(120.0, 45.0, 80.0, 150.0, 95.0)
    val quantities = DenseVector(250.0, 600.0, 320.0, 180.0, 210.0)

    // Vectorized Element-wise Multiplication using Breeze's *:* operator
    val revenues = prices *:* quantities
    val totalGross = sum(revenues)
    val meanRevenue = mean(revenues)

    println("=== Breeze Numerical Computations: Total Revenue per Fruit ===") 
    println(s"Price Vector (INR):    $prices")
    println(s"Quantity Vector:       $quantities")
    println(s"Revenue Vector (INR):  $revenues\n")
    for (i <- 0 until fruits.length) {
      println(f"  ${fruits(i)}%-7s -> INR ${revenues(i)}%,10.2f")
    }
    println(f"\nTotal Gross Revenue: INR $totalGross%,10.2f")
    println(f"Mean Revenue/Fruit:  INR $meanRevenue%,10.2f")

    // 2. Interactive Bar Chart Visualization with Plotly.Scala
    import plotly._, plotly.element._, plotly.layout._

    val barTrace = Bar(
      fruits.toSeq,
      revenues.toArray.toSeq,
      name = "Revenue (INR)",
      marker = Marker(color = Seq(
        Color.StringColor("#3182ce"),
        Color.StringColor("#38a169"),
        Color.StringColor("#dd6b20"),
        Color.StringColor("#d69e2e"),
        Color.StringColor("#805ad5")
      ))
    )
    val plotLayout = Layout(
      title = "Total Revenue by Fruit Category (Breeze & Plotly.Scala)",
      xaxis = plotly.layout.Axis(title = "Fruit Variety"),
      yaxis = plotly.layout.Axis(title = "Total Revenue (INR)")
    )
    Plotly.plot("fruit_revenue.html", Seq(barTrace), plotLayout)
    println("\nPlot saved successfully as 'fruit_revenue.html'")
  }
}
