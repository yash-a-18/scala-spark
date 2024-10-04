package example

import org.apache.spark.sql.SparkSession

object SimpleJSONApp{
  def main(args: Array[String]): Unit = {
    println("greeting")
    val spark = SparkSession.builder()
      .appName("spark-scala-project")
      .master("local[*]")//As we are running our peoject locally and standalone, * is for the number of cores we want to use on my system
      .getOrCreate()

      val dataframe = spark.read
      .option("multiline", true)
      .json("data/patients.json")

      dataframe.show()// prints 20 row by default
      dataframe.printSchema() // prints the schema of the dataframe
  }
}