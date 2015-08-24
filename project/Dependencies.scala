import sbt._
import Keys._

object Dependencies {
  val dispatchVersion = "0.11.3"
  val slf4jVersion = "1.7.12"
  val log4j2Version = "2.3"
  val specs2Version = "3.6.4"
  val typesafeLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  val betaMax = "co.freeside" % "betamax" % "1.1.2"
  val groovy = "org.codehaus.groovy" % "groovy-all" % "2.4.4"
  def dispatchDep(artifactName: String) = {
    "net.databinder.dispatch" %% s"dispatch-${artifactName}" % dispatchVersion
  }

  def slf4jDep(artifactName: String) = {
    "org.slf4j" % s"slf4j-${artifactName}" % slf4jVersion
  }

  def log4j2Dep(artifactName: String) = {
    "org.apache.logging.log4j" % s"log4j-${artifactName}" % log4j2Version
  }

  def specs2Dep(artifactName: String) = {
    "org.specs2" %% s"specs2-${artifactName}" % specs2Version
  }

  val dispatchDependencies = Seq(dispatchDep("core"), dispatchDep("lift-json"))
  val loggingDependencies = Seq(slf4jDep("api"), log4j2Dep("api"), log4j2Dep("core"), log4j2Dep("slf4j-impl"))
  val typesafeDeps = Seq("com.github.kxbmap" %% "configs" % "0.2.4")
  val testDependencies = Seq(specs2Dep("core") % "test", specs2Dep("matcher-extra") % "test", betaMax % "test", groovy % "test")
  val apiDependencies = dispatchDependencies ++ loggingDependencies ++ testDependencies ++ typesafeDeps
}
