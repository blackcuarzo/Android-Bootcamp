package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.uilayer.MovieListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.uilayer.viewmodels.MoviesViewModel

class SearchFragment : Fragment() {
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

//        //Code goes here
        val movieList: RecyclerView = view.findViewById(R.id.movieList)
        movieList.layoutManager = LinearLayoutManager(requireContext())
        val movieListAdapter = MovieListAdapter(::showMovieDetails)
        movieList.adapter = movieListAdapter
        val moviesObserver = Observer<List<MovieModel>>{
                movieItemsList -> movieListAdapter.submitList(movieItemsList)
        }
        viewModel.movieList.observe(viewLifecycleOwner,moviesObserver)

        viewModel.status.observe(requireActivity()){
            view.findViewById<TextView>(R.id.statusText).text = it
        }

        return view
    }
    private fun showMovieDetails(movie: MovieModel){
        val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(
            name = movie.name,
            nameEs = movie.nameEs,
            synopsis = movie.synopsis,
            preview = movie.preview,
            thumbnail = movie.thumbnail,
            shortDescription = movie.synopsis,
            numberEpisodes = movie.numberEpisodes)
        findNavController().navigate(action)
    }
}

