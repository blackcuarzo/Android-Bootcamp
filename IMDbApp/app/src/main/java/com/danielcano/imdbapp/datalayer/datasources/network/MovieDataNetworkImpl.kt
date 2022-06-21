package com.danielcano.imdbapp.datalayer.datasources.network

import com.danielcano.imdbapp.datalayer.datasources.MovieDtoLocal
import com.danielcano.imdbapp.datalayer.datasources.MoviesData

class MovieDataNetworkImpl:MoviesData {
    override suspend fun getMoviesList(): List<MovieDtoLocal> {
        val remoteData = MoviesApi.retrofitService.getMoviesList()
        val convertedData = AdapterNetworkToLocal().convertData(remoteData)
        return convertedData
    }
}