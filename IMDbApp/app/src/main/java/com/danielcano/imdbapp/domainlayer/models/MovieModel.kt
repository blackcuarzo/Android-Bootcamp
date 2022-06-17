package com.danielcano.imdbapp.domainlayer.models

data class MovieModel (
    val name: String,
    val name_es:String,
    val year: String,
    val actors: String,
    val rating:Float,
    val thumbnail:Int,
    val synopsis:String,
    val preview:Int,
    val numberEpisodes:Int,
    val category:String,
    )