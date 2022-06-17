package com.danielcano.imdbapp.datalayer.datasources

interface MoviesLocalDataSource {
    fun getMoviesData():List<MovieData>
}