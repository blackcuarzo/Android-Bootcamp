package com.danielcano.imdbapp

import android.content.res.Resources

fun movies (resources: Resources): List<Movie> {
    return listOf(
        Movie(
            name = resources.getString(R.string.movie1_name),
            year = 2022,
            actors = resources.getString(R.string.movie1_actors),
            description = resources.getString(R.string.movie1_description),
            rating = 8.8F,
            thumbnail = R.drawable.dune_thumbnail
        ),
        Movie(
            name = resources.getString(R.string.movie2_name),
            year = 2015,
            actors = resources.getString(R.string.movie2_actors),
            description = resources.getString(R.string.movie2_description),
            rating = 9.0F,
            thumbnail = R.drawable.madmax_thumbnail

        ),
        Movie(
            name = resources.getString(R.string.movie3_name),
            year = 2022,
            actors = resources.getString(R.string.movie3_actors),
            description = resources.getString(R.string.movie3_description),
            rating = 6.5F,
            thumbnail = R.drawable.batman_thumbnail
        ),
        Movie(
            name = resources.getString(R.string.movie4_name),
            year = 2016,
            actors = resources.getString(R.string.movie4_actors),
            description = resources.getString(R.string.movie4_description),
            rating = 8.0F,
            thumbnail = R.drawable.deadpool_thumbnail
        ),
        Movie(
            name = resources.getString(R.string.movie5_name),
            year = 2021,
            actors = resources.getString(R.string.movie5_actors),
            description = resources.getString(R.string.movie5_description),
            rating = 9.8F,
            thumbnail = R.drawable.spiderman_thumbnail
        )

    )
}