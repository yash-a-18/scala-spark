package example

import org.apache.spark.sql.SparkSession

object SimpleApp{
  def main(args: Array[String]): Unit = {
    println("greeting")
    val spark = SparkSession.builder()
      .appName("spark-scala-project")
      .master("local[*]")//As we are running our peoject locally and standalone, * is for the number of cores we want to use on my system
      .getOrCreate()

      val dataframe = spark.read
      .option("header", value = "true")
      .csv("data/AAPL.csv")

      dataframe.show()// prints 20 row by default
  }
}