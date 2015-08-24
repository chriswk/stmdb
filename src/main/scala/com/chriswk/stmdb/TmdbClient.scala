package com.chriswk.stmdb

import com.chriswk.stmdb.domain.{TmdbPerson, TmdbMovie, TmdbConfiguration}
import dispatch._
import Defaults._
import com.github.kxbmap.configs._
import com.typesafe.config.ConfigFactory

object TmdbClient {
  implicit val formats = net.liftweb.json.DefaultFormats
  val config = ConfigFactory.load("stmdb.conf")
  val baseUrl = config.opt[String]("tmdbBaseUrl") getOrElse "https://api.themoviedb.org/3"
  val apiKey = config.get[String]("tmdbApiKey")
  val base = url(baseUrl).addQueryParameter("api_key", apiKey)
  val configurationUrl = base / "configuration"
  val movieUrl = base / "movie"
  val personUrl = base / "person"


  def configuration: Future[TmdbConfiguration] = {
    val req = configurationUrl
    for (g <- Http(req OK as.lift.Json))
      yield g.extract[TmdbConfiguration]
  }

  def movie(id: Long): Future[TmdbMovie] = {
    val req = movieUrl / id
    for (m <- Http(req OK as.lift.Json))
      yield m.extract[TmdbMovie]
  }

  def person(id: Long): Future[TmdbPerson] = {
    val req = personUrl / id
    for (p <- Http(req OK as.lift.Json))
      yield p.extract[TmdbPerson]
  }
}
