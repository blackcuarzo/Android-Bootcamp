package com.danielcano.imdbapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val nameText = itemView.findViewById<TextView>(R.id.nameText)
    private val actorsText = itemView.findViewById<TextView>(R.id.actorsText)
    private val thumbnailImage: ImageView = itemView.findViewById(R.id.thumbnailImage)
    private val yearText:TextView = itemView.findViewById(R.id.yearText)

    fun bind(movie: Movie){
        nameText.text = movie.name
        actorsText.text = movie.actors
        yearText.text = movie.year.toString()
        thumbnailImage.setImageResource(movie.thumbnail)
    }
}

class MovieListAdapter(): ListAdapter<Movie,MovieViewHolder>(MovieDiffCallback) {
    object MovieDiffCallback:DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
            // alternative would be return oldItem.id == oldItem.id, which might be more efficient for big objects
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        Toast.makeText(parent.context, "Holder created", Toast.LENGTH_SHORT).show()
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

}