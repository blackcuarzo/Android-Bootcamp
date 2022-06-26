package com.danielcano.imdbapp.datalayer.datasources.network

class MoviesNetworkDataSourceImpl : MoviesNetworkDataSource {
    override suspend fun getMoviesList(): List<MovieDtoNetwork> {
        return MoviesApi.retrofitService.getApiResponse().results
    }
}