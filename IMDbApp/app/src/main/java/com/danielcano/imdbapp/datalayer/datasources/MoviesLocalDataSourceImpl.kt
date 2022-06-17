package com.danielcano.imdbapp.datalayer.datasources

import android.content.res.Resources
import com.danielcano.imdbapp.datalayer.requestMoviesSource

class MoviesLocalDataSourceImpl(private val resources: Resources):MoviesLocalDataSource {
    override fun getMoviesData():List<MovieData>{
        return requestMoviesSource(resources)
    }
}