package com.danielcano.imdbapp.datalayer.datasources

interface MoviesDataLocal {
    fun getMoviesList():List<MovieDtoLocal>
}