package com.danielcano.imdbapp.datalayer.datasources

data class MovieDtoLocal (
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