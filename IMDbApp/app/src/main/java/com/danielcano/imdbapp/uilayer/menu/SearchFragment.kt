package com.danielcano.imdbapp.uilayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.datalayer.Movie
import com.danielcano.imdbapp.uilayer.MovieListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.movies

class SearchFragment : Fragment() {

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

        val itemList = movies(this.resources)
        movieListAdapter.submitList(itemList)

        return view
    }
    private fun showMovieDetails(movie: Movie){
        val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(name = movie.name, nameEs = movie.name_es, synopsis = movie.synopsis,preview = movie.preview,thumbnail = movie.thumbnail,shortDescription = movie.synopsis,numberEpisodes = movie.numberEpisodes)
        findNavController().navigate(action)
    }
}

