import sbt._
import Keys._

/*
 * Project Build File
 *
 * Template copied from:
 *  http://www.scala-sbt.org/release/docs/Examples/Full-Configuration-Example.html
 */

object BuildSettings {
  val buildOrganization = "johnmurray.io"
  val buildVersion      = "0.1"
  val buildScalaVersion = "2.10.2"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion
  )
}

object Resolvers {

}

object Dependencies {

}

object ApplicationBuild extends Build {
  import BuildSettings._
  import Resolvers._
  import Dependencies._

  lazy val main = Project(
    "experiments-in-scala",
    file("."),
    settings = buildSettings)
}
