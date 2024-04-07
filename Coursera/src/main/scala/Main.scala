
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object Main {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("Coursera")
      .master("local[*]")
      .getOrCreate()

    // Set log level to ERROR to avoid verbose output
    spark.sparkContext.setLogLevel("ERROR")

    // Path to your CSV file
    val filePath = "C:/Users/Deema/IdeaProjects/Coursera/src/main/CourseraDataset-Clean.csv"

    // Read CSV file into DataFrame
    val df: DataFrame = spark.read
      .format("csv")
      .option("header", "true") // If your CSV has a header
      .option("inferSchema", "true") // Infer schema automatically
      .load(filePath)

    // Show DataFrame schema and some data
    df.printSchema()
    df.show(3)

    val snowflakeOptions =SnowflakeConfig.options

    // Write DataFrame to Snowflake
    df.write
      .format("net.snowflake.spark.snowflake")
      .options(snowflakeOptions)
      .option("dbtable", "COURSES")
      .mode(SaveMode.Overwrite)
      .save()

    spark.stop()
  }

}
