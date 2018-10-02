import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.hochgi",
      scalaVersion := "2.12.7",
      version      := "0.0.1-SNAPSHOT"
    )),
    name := "scala-jenetics",
    libraryDependencies ++= Seq(
      "io.jenetics" % "jenetics" % "4.2.1",
      scalaTest % Test
    )
  )
