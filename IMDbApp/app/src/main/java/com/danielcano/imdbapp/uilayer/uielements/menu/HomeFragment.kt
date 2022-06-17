package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.uilayer.MovieListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.uilayer.viewmodels.MoviesViewModel

class HomeFragment: Fragment() {

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

        val moviesObserver = Observer<List<MovieModel>>{
                movieItemsList -> movieListAdapter.submitList(movieItemsList)
        }
        val moviesViewModel = MoviesViewModel()
        moviesViewModel.movieList.observe(viewLifecycleOwner,moviesObserver)
        moviesViewModel.loadMovies()
        return view
    }

    private fun showMovieDetails(movie: MovieModel){
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(name = movie.name, nameEs = movie.name_es, synopsis = movie.synopsis,preview = movie.preview,thumbnail = movie.thumbnail,shortDescription = movie.synopsis,numberEpisodes = movie.numberEpisodes)
        findNavController().navigate(action)
    }
}