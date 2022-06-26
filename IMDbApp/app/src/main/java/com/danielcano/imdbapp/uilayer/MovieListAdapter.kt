package com.danielcano.imdbapp.uilayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MovieListAdapter(private val clickHandler: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, MovieViewHolder>(
        MovieDiffCallback
    ) {
    object MovieDiffCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
            // alternative would be return oldItem.id == oldItem.id, which might be more efficient for big objects
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            clickHandler(movie)
        }
    }

}