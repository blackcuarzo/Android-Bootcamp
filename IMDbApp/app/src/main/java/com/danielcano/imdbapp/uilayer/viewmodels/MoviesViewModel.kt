package com.danielcano.imdbapp.uilayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.datalayer.datasources.network.MoviesNetworkDataSourceImpl
import com.danielcano.imdbapp.datalayer.repositories.MoviesRepositoryImpl
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.domainlayer.usecases.GetMoviesForUICaseImpl
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    private val _movieList =  MutableLiveData<List<MovieModel>>()
    val movieList:LiveData<List<MovieModel>> = _movieList
    private val _filteredMovieList =  MutableLiveData<List<MovieModel>>()
    val filteredMovieList:LiveData<List<MovieModel>> = _filteredMovieList
    private val _status = MutableLiveData<String>()
    val status:LiveData<String> = _status

    private val usecase =
        GetMoviesForUICaseImpl(MoviesRepositoryImpl(MoviesNetworkDataSourceImpl()))

    init {
        loadMovies()
    }

    private fun loadMovies(){
        viewModelScope.launch {
            try{
                _movieList.value = usecase.getMovies()
                _status.value = "Successfully loaded ${movieList.value!!.size} items"
                _filteredMovieList.value = _movieList.value
            }catch (e:Exception){
                _movieList.value = listOf()
                _status.value = "Failed to load, Error: ${e.localizedMessage}"
            }
        }
    }
    fun filterMovies(query:String?){
        val searchResult: List<MovieModel>? =
            if (query == "" || query == null){
                listOf()
            }else{
               movieList.value!!.filter {movieModel ->
                    movieModel.name.contains(query)
                }
            }
        _filteredMovieList.value = searchResult!!
        _status.value = "We have ${filteredMovieList.value?.size} items"
    }

}