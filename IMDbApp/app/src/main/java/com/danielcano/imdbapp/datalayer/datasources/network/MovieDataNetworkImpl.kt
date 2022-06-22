package com.danielcano.imdbapp.datalayer.datasources.network

class MovieDataNetworkImpl:MoviesDataNetwork {
    override suspend fun getMoviesList(): ImdbNetworkResponse {
        return MoviesApi.retrofitService.getMoviesList()
    }
}