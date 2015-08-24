import Dependencies._

organization := "com.chriswk"

name := "stmdb"

description := "This library provides a scala wrapper around the JSON API provided by by TMdB, which is an open database for movie and film content."

scalaVersion := "2.11.7"

seq(lsSettings :_*)

(LsKeys.tags in LsKeys.lsync) := Seq("TheMovieDb", "tmdb", "dispatch")

libraryDependencies ++= apiDependencies

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

