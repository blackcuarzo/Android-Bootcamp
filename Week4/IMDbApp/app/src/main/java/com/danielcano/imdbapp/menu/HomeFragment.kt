package com.danielcano.imdbapp.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.Movie
import com.danielcano.imdbapp.MovieListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.movies

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

        val itemList = movies(this.resources)
        movieListAdapter.submitList(itemList)

        return view
    }

    private fun showMovieDetails(movie:Movie){
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movie.name)
        findNavController().navigate(action)
    }
}