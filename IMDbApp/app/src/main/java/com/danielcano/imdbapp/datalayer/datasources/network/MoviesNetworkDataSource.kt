package com.danielcano.imdbapp.datalayer.datasources.network

interface MoviesNetworkDataSource {
    suspend fun getMoviesList():ImdbApiServiceResponse
}