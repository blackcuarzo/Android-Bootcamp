package com.danielcano.imdbapp.datalayer.datasources.network

class MoviesNetworkDataSourceImpl : MoviesNetworkDataSource {
    override suspend fun getTopRatedMovies(): List<MovieDtoNetwork> {
        return MoviesApi.retrofitService.getTopRatedMovies().results
    }

    override suspend fun getListOfMovies(): List<MovieDtoNetwork> {
        return MoviesApi.retrofitService.getListOfMovies().items
    }
}