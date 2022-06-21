package com.danielcano.imdbapp.datalayer.datasources

import com.danielcano.imdbapp.datalayer.requestMoviesSource

class MoviesDataLocalImpl():MoviesData {
    override suspend fun getMoviesList():List<MovieDtoLocal>{
        return requestMoviesSource()
    }
}