package com.danielcano.imdbapp.datalayer.datasources.network

interface MoviesDataNetwork {
    suspend fun getMoviesList():List<MovieDtoNetwork>
}