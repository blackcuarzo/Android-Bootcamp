package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.domainlayer.models.MovieModel

interface MoviesRepository {
    fun getMovies():List<MovieModel>
}