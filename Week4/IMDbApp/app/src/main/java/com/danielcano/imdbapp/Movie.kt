package com.danielcano.imdbapp

import androidx.annotation.DrawableRes


data class Movie (
    val name: String,
    val description: String,
    val year: Int,
    val actors: String,
    val rating:Float,
    @DrawableRes
    val thumbnail:Int
    )