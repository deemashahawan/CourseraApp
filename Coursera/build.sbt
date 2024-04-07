ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "Coursera"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.5.0",
  "org.apache.spark" %% "spark-sql" % "3.5.0" % "provided",
  "net.snowflake" % "snowflake-jdbc" % "3.15.0",
  "net.snowflake" %% "spark-snowflake" % "2.14.0-spark_3.4"
)