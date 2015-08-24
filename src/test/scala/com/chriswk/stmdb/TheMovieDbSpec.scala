package com.chriswk.stmdb

import com.chriswk.stmdb.domain.TmdbPerson
import scala.concurrent.ExecutionContext.Implicits.global
import org.specs2.mutable._

import scala.util.Success

class TheMovieDbSpec extends Specification {
  "The TMDB Client" should {
    "find Al Pacino" in BetaMax("tmdb client") {
      TmdbClient.person(1158) onComplete { req => {
        req match {
          case Success(pacino) => pacino.name must be_==("Al Pacino")
          case _ => ko("Failed to parse response")
        }
      }
      }
    }
  }
}
