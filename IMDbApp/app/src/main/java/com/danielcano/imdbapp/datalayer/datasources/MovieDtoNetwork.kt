package com.danielcano.imdbapp.datalayer.datasources

import android.icu.text.CaseMap
import com.squareup.moshi.Json

data class MovieDtoNetwork (
    val id: Int,
    @Json(name = "original_title")
    val originalTitle: String,
    val title:String,
    @Json(name = "release_date")
    val releaseDate:String,
    val popularity:Float,



//    val name: String,
//    val name_es:String,
//    val year: String,
//    val actors: String,
//    val rating:Float,
//    val thumbnail:Int,
//    val synopsis:String,
//    val preview:Int,
//    val numberEpisodes:Int,
//    val category:String,
    )