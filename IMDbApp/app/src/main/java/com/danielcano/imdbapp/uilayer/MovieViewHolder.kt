package com.danielcano.imdbapp.uilayer

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val nameText = itemView.findViewById<TextView>(R.id.movieNameText)
    private val actorsText = itemView.findViewById<TextView>(R.id.movieActorsText)
    private val thumbnailImage: ImageView = itemView.findViewById(R.id.movieThumbnailImage)
    private val yearText: TextView = itemView.findViewById(R.id.movieYearText)

    fun bind(movie: MovieModel){
        nameText.text = movie.name
        actorsText.text = movie.actors
        yearText.text = movie.year
        thumbnailImage.load(movie.thumbnail)
    }
}