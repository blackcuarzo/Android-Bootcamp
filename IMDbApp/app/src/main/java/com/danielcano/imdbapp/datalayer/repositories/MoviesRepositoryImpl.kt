package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.datasources.MoviesDataLocal
import com.danielcano.imdbapp.datalayer.datasources.MovieDtoLocal
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MoviesRepositoryImpl (private val datasource:MoviesDataLocal):MoviesRepository{

    override fun getMovies(): List<MovieModel> {
        val moviesData= datasource.getMoviesList()
        val moviesModel = modelData(moviesData)
        return moviesModel
    }

    fun modelData(moviesUnprocesed:List<MovieDtoLocal>):List<MovieModel>{
        val moviesProcessed = mutableListOf<MovieModel>()
        moviesUnprocesed.forEach{
                movieData -> moviesProcessed.add(
            MovieModel(
                movieData.name,
                movieData.name_es,
                movieData.year,
                movieData.actors,
                movieData.rating,
                movieData.thumbnail,
                movieData.synopsis,
                movieData.preview,
                movieData.numberEpisodes,
                movieData.category,
            )
        )
        }
        return moviesProcessed
    }
}