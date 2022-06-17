package com.danielcano.imdbapp.uilayer.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.uilayer.MovieListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.datasources.MoviesLocalDataSourceImpl
import com.danielcano.imdbapp.datalayer.repositories.MoviesRepositoryImpl
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class HomeFragment: Fragment() {

//    private val moviesRepository = MoviesRepository(MoviesLocalDataSource(this.resources))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val movieList: RecyclerView = view.findViewById(R.id.recomendationList)
        movieList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val movieListAdapter = MovieListAdapter(::showMovieDetails)
        movieList.adapter = movieListAdapter

//        val itemList = movies(this.resources)
        val itemList = MoviesRepositoryImpl(MoviesLocalDataSourceImpl(this.resources)).getMovies()
        movieListAdapter.submitList(itemList)
//        val moviesObserver = Observer<List<MovieModel>>{
//            movieItem -> movieListAdapter.submitList(movieItem)
//        }
//
//        moviesRepository.movieList.observe(viewLifecycleOwner,moviesObserver)
//        moviesRepository.getMovies()

        return view
    }

    private fun showMovieDetails(movie: MovieModel){
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(name = movie.name, nameEs = movie.name_es, synopsis = movie.synopsis,preview = movie.preview,thumbnail = movie.thumbnail,shortDescription = movie.synopsis,numberEpisodes = movie.numberEpisodes)
        findNavController().navigate(action)
    }
}