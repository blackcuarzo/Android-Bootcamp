package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.domainlayer.models.MovieModel

interface GetMoviesForUICase {
    fun getMovies():List<MovieModel>
}