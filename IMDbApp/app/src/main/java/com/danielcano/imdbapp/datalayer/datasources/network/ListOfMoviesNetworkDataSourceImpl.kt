package com.danielcano.imdbapp.datalayer.datasources.network

class ListOfMoviesNetworkDataSourceImpl : MoviesNetworkDataSource {
    override suspend fun getMovies(): List<MovieDtoNetwork> {
        return MoviesApi.retrofitService.getListOfMovies().items
    }
}