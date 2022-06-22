package com.danielcano.imdbapp.uilayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.datalayer.datasources.MoviesDataLocalImpl
import com.danielcano.imdbapp.datalayer.repositories.MoviesRepositoryImpl
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.domainlayer.usecases.GetMoviesForUICaseImpl
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    private val _movieList =  MutableLiveData<List<MovieModel>>()
    val movieList:LiveData<List<MovieModel>> = _movieList

    val usecase =
        GetMoviesForUICaseImpl(MoviesRepositoryImpl(MoviesDataLocalImpl()))

    fun loadMovies(){
        viewModelScope.launch {
            _movieList.value = usecase.getMovies()
        }
    }
}