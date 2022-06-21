package com.danielcano.imdbapp.datalayer.datasources

interface MoviesData {
    suspend fun getMoviesList():List<MovieDtoLocal>
}