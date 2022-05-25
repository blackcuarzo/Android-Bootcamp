package com.danielcano.imdbapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val nameText = itemView.findViewById<TextView>(R.id.nameText)
    private val actorsText = itemView.findViewById<TextView>(R.id.actorsText)
    private val thumbnailImage: ImageView = itemView.findViewById(R.id.thumbnailImage)
    private val yearText: TextView = itemView.findViewById(R.id.yearText)

    fun bind(movie: Movie){
        nameText.text = movie.name
        actorsText.text = movie.actors
        yearText.text = movie.year.toString()
        thumbnailImage.setImageResource(movie.thumbnail)
    }
}