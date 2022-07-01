package com.danielcano.imdbapp.datalayer.datasources.network

class TopRatedMoviesNetworkDataSourceImpl : MoviesNetworkDataSource {
    override suspend fun getMovies(): List<MovieDtoNetwork> {
        return MoviesApi.retrofitService.getTopRatedMovies().results
    }
}