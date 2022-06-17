package com.danielcano.imdbapp.datalayer.datasources

import com.danielcano.imdbapp.datalayer.requestMoviesSource

class MoviesLocalDataSourceImpl():MoviesLocalDataSource {
    override fun getMoviesData():List<MovieData>{
        return requestMoviesSource()
    }
}