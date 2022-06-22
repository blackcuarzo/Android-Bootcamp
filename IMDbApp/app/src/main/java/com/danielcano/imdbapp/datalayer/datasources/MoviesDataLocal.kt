package com.danielcano.imdbapp.datalayer.datasources

interface MoviesDataLocal {
    suspend fun getMoviesList():List<MovieDtoLocal>
}