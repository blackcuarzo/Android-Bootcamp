package com.danielcano.imdbapp.datalayer.datasources.network

interface MoviesNetworkDataSource {
    suspend fun getMovies(): List<MovieDtoNetwork>
}