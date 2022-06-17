package com.danielcano.imdbapp.uilayer.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.uilayer.MovieListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.datasources.MoviesLocalDataSourceImpl
import com.danielcano.imdbapp.datalayer.repositories.MoviesRepositoryImpl
import com.danielcano.imdbapp.domainlayer.models.MovieModel

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

//        val itemList = requestMoviesSource(this.resources)
//        movieListAdapter.submitList(itemList)
        val itemList = MoviesRepositoryImpl(MoviesLocalDataSourceImpl(this.resources)).getMovies()
        movieListAdapter.submitList(itemList)
//        val moviesObserver = Observer<List<MovieModel>>{
//                movieItem -> movieListAdapter.submitList(movieItem)
//        }
//        moviesRepository.movieList.observe(viewLifecycleOwner,moviesObserver)
//        moviesRepository.getMovies()
        return view
    }
    private fun showMovieDetails(movie: MovieModel){
        val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(name = movie.name, nameEs = movie.name_es, synopsis = movie.synopsis,preview = movie.preview,thumbnail = movie.thumbnail,shortDescription = movie.synopsis,numberEpisodes = movie.numberEpisodes)
        findNavController().navigate(action)
    }
}

