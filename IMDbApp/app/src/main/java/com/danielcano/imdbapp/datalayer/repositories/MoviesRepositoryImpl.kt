package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.datasources.network.MoviesDataNetwork
import com.danielcano.imdbapp.datalayer.datasources.translaters.MapperNetworkToDomainModel
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MoviesRepositoryImpl (private val datasource:MoviesDataNetwork):MoviesRepository{

    override suspend fun getMovies(): List<MovieModel> {
        val moviesData= datasource.getMoviesList()
        val moviesModel = MapperNetworkToDomainModel().convertData(moviesData)
        return moviesModel
    }


}