package com.chriswk.stmdb

import co.freeside.betamax.TapeMode
import com.chriswk.stmdb.domain.{TmdbMovie, TmdbPerson}
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import org.specs2.mutable._

import scala.concurrent.duration.Duration
import scala.util.Success

class TheMovieDbSpec extends Specification {
  "The TMDB Client" should {
    "find Al Pacino" in BetaMax("tmdb person") {
      val result: TmdbPerson = Await.result(TmdbClient.person(1158), 5 second)
      result.name must equalTo("Al Pacino")
    }
    "find Godfather" in BetaMax("tmdb movie") {
      val result: TmdbMovie = Await.result(TmdbClient.movie(238), 5 second)
      result.title must equalTo("The Godfather")
    }
  }
}
