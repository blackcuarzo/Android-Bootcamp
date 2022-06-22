package com.danielcano.imdbapp.uilayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.datalayer.datasources.network.MovieDataNetworkImpl
import com.danielcano.imdbapp.datalayer.repositories.MoviesRepositoryImpl
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.domainlayer.usecases.GetMoviesForUICaseImpl
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    private val _movieList =  MutableLiveData<List<MovieModel>>()
    val movieList:LiveData<List<MovieModel>> = _movieList
    private val _status = MutableLiveData<String>()
    val status:LiveData<String> = _status


    val usecase =
        GetMoviesForUICaseImpl(MoviesRepositoryImpl(MovieDataNetworkImpl()))

    init {
        loadMovies()
    }

    fun loadMovies(){
        viewModelScope.launch {
            try{
                _movieList.value = usecase.getMovies()
                _status.value = "Successfully loaded"
            }catch (e:Exception){
                _movieList.value = listOf<MovieModel>()
                _status.value = "Failed to load, Error: ${e.message}"
            }
        }
    }
}