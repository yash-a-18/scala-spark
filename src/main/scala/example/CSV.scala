package example

import org.apache.spark.sql.SparkSession

object SimpleCSVApp{
  def main(args: Array[String]): Unit = {
    println("greeting")
    val spark = SparkSession.builder()
      .appName("spark-scala-project")
      .master("local[*]")//As we are running our peoject locally and standalone, * is for the number of cores we want to use on my system
      .getOrCreate()

      val dataframe = spark.read
      .option("header", value = "true")// set true if csv file contains header
      .option("inferSchema", value = "true")// set true to set correct datatype for each column
      .csv("data/AAPL.csv")

      dataframe.show()// prints 20 row by default
      dataframe.printSchema() // prints the schema of the dataframe
  }
}