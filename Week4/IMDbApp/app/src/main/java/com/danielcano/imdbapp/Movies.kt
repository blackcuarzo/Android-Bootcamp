package com.danielcano.imdbapp

import android.content.res.Resources

fun movies (resources: Resources): List<Movie> {
    return listOf(
        Movie(
            name = resources.getString(R.string.movie1_name),
            year = 2022,
            actors = "Timothée Chalamet, Zendaya",
            description = resources.getString(R.string.movie1_description),
            rating = 8.8F),
        Movie(
            name = resources.getString(R.string.movie2_name),
            year = 2015,
            actors = "Tom Hardy, Charlize Theron",
            description = resources.getString(R.string.movie2_description),
            rating = 9.0F ),
        Movie(
            name = resources.getString(R.string.movie3_name),
            year = 2022,
            actors = "Robert Pattinson, Zoë Kravitz",
            description = resources.getString(R.string.movie3_description),
            rating = 6.5F
        )
    )
}