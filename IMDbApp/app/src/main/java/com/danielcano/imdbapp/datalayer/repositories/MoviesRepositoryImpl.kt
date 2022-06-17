package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.datasources.MoviesLocalDataSource
import com.danielcano.imdbapp.datalayer.datasources.MovieData
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MoviesRepositoryImpl (private val datasource:MoviesLocalDataSource):MoviesRepository{

    private val _movieList:MutableList<MovieModel> =  mutableListOf<MovieModel>()
    val movieList:List<MovieModel> = _movieList

    override fun getMovies(): List<MovieModel> {
        val moviesData= datasource.getMoviesData()
        val moviesModel = modelData(moviesData)
//        _movieList.value = moviesModel
        return moviesModel
    }

    fun modelData(moviesUnprocesed:List<MovieData>):List<MovieModel>{
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