package com.danielcano.imdbapp.datalayer.datasources

import com.danielcano.imdbapp.datalayer.requestMoviesSource

class MoviesDataLocalImpl():MoviesDataLocal {
    override fun getMoviesList():List<MovieDtoLocal>{
        return requestMoviesSource()
    }
}