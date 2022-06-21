package com.danielcano.imdbapp.datalayer.datasources.network

import com.squareup.moshi.Json

data class MovieDtoNetwork (
    val id: Int,
    val title:String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "release_date")
    val releaseDate:String,
    val popularity:Float,
    val overview:String
    )