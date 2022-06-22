package com.danielcano.imdbapp.datalayer.datasources.translaters

import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.datasources.MovieDtoLocal
import com.danielcano.imdbapp.datalayer.datasources.network.MovieDtoNetwork
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MapperNetworkToDomainModel () {
    private val imgUrlBase = "https://image.tmdb.org/t/p/w500"

    fun convertData(remoteData:List<MovieDtoNetwork>):List<MovieModel>{
        val convertedData = mutableListOf<MovieModel>()

        remoteData.forEach{
                remoteMovie -> convertedData.add(
                    MovieModel(
                        name = remoteMovie.originalTitle,
                        nameEs = remoteMovie.title,
                        year = remoteMovie.releaseDate,
                        actors = "",
                        rating = remoteMovie.popularity,
                        thumbnail = imgUrlBase + remoteMovie.posterPath,
                        category = "Movie",
                        numberEpisodes = 1,
                        synopsis = remoteMovie.overview,
                        preview = imgUrlBase + remoteMovie.backdropPath
                    )
                )
        }
        return convertedData
    }

}