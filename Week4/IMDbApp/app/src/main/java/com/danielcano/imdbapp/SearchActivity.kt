package com.danielcano.imdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val movieList:RecyclerView = findViewById(R.id.movieList)

        movieList.layoutManager = LinearLayoutManager(this)

        val movieListAdapter = MovieListAdapter()
        movieList.adapter = movieListAdapter

    }
}