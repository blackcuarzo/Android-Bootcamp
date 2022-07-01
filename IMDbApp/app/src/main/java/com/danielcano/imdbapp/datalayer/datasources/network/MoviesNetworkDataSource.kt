package com.danielcano.imdbapp.datalayer.datasources.network

interface MoviesNetworkDataSource {
    suspend fun getTopRatedMovies(): List<MovieDtoNetwork>
    suspend fun getListOfMovies(): List<MovieDtoNetwork>
}