package com.danielcano.imdbapp.datalayer.datasources.network

class MoviesNetworkDataSourceImpl:MoviesNetworkDataSource {
    override suspend fun getMoviesList(): ImdbApiServiceResponse {
        return MoviesApi.retrofitService.getApiResponse()
    }
}