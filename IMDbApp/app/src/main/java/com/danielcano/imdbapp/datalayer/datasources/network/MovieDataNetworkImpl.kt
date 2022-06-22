package com.danielcano.imdbapp.datalayer.datasources.network

class MovieDataNetworkImpl:MoviesDataNetwork {
    override suspend fun getMoviesList(): List<MovieDtoNetwork> {
        val remoteData = MoviesApi.retrofitService.getMoviesList()
        return remoteData
    }
}