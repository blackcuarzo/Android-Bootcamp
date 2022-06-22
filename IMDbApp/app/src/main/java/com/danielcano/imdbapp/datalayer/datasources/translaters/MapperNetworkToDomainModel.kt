package com.danielcano.imdbapp.datalayer.datasources.translaters

import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.datasources.MovieDtoLocal
import com.danielcano.imdbapp.datalayer.datasources.network.MovieDtoNetwork

class MapperNetworkToDomainModel () {

    fun convertData(remoteData:List<MovieDtoNetwork>):List<MovieDtoLocal>{
        val convertedData = mutableListOf<MovieDtoLocal>()

        remoteData.forEach{
                remoteMovie -> convertedData.add(
                    MovieDtoLocal(
                        name = remoteMovie.originalTitle,
                        nameEs = remoteMovie.title,
                        year = remoteMovie.releaseDate,
                        actors = "",
                        rating = remoteMovie.popularity,
                        thumbnail = R.drawable.dune_thumbnail,
                        category = "Movie",
                        numberEpisodes = 1,
                        synopsis = remoteMovie.overview,
                        preview = R.drawable.dune_preview
                    )
                )
        }
        return convertedData
    }

}