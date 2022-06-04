package com.danielcano.imdbapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val nameText = itemView.findViewById<TextView>(R.id.movieNameText)
    private val actorsText = itemView.findViewById<TextView>(R.id.movieActorsText)
    private val thumbnailImage: ImageView = itemView.findViewById(R.id.movieThumbnailImage)
    private val yearText: TextView = itemView.findViewById(R.id.movieYearText)

    fun bind(movie: Movie){
        nameText.text = movie.name
        actorsText.text = movie.actors
        yearText.text = movie.year.toString()
        thumbnailImage.setImageResource(movie.thumbnail)
    }
}