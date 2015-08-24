package com.chriswk.stmdb.domain

import java.util.Date


case class Images(base_url: String, secure_base_url: String, backdrop_sizes: List[String], logo_sizes: List[String],
                  poster_sizes: List[String], profile_sizes: List[String], still_sizes: List[String])
case class TmdbConfiguration(images: Images, change_keys: List[String])
case class TmdbGenre(id: Long, name: String)
case class ProductionCompany(id: Long, name: String)
case class TmdbCountry(iso_3166_1: String, name: String)
case class TmdbLanguage(iso_639_1: String, name: String)
case class TmdbMovie(adult: Boolean, backdrop_path: String, budget: Option[Long], genres: List[TmdbGenre],
                     homepage: String, id: Long, imdb_id: String, original_language: String, original_title: String,
                     overview: String, poster_path: String, production_companies: List[ProductionCompany],
                     production_countries: List[TmdbCountry],
                     release_date: String, revenue: Long, runtime: Long, spoken_languages: List[TmdbLanguage],
                     status: String, tagline: String,
                     title: String, video: Boolean)

case class TmdbPerson(adult: Boolean, also_known_as: List[String], biography: String, birthday: Option[String],
                      deathday: Option[String], homepage: String, id: Long, name: String, place_of_birth: String,
                      profile_path: String)