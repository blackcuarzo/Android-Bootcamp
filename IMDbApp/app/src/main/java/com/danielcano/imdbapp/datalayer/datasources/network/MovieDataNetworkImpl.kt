package com.danielcano.imdbapp.datalayer.datasources.network

class MovieDataNetworkImpl:MoviesDataNetwork {
    override suspend fun getMoviesList(): List<MovieDtoNetwork> {
        return MoviesApi.retrofitService.getMoviesList()
    }
}