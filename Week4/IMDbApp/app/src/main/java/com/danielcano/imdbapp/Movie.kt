package com.danielcano.imdbapp

data class Movie (
    val id:Int,
    val name: String,
    val description: String,
    val year: Int,
    val actors: String,
    val rating:Float
    )