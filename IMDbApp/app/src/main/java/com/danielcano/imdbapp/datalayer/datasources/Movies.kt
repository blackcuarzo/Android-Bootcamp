package com.danielcano.imdbapp.datalayer

import android.content.res.Resources
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.datasources.MovieData

fun requestMoviesSource (resources: Resources): List<MovieData> {
    return listOf(
        MovieData(
            name = resources.getString(R.string.movie1_name),
            name_es = "Duna",
            year = "2022",
            actors = resources.getString(R.string.movie1_actors),
            synopsis = resources.getString(R.string.movie1_synopsis),
            rating = 8.8F,
            thumbnail = R.drawable.dune_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.dune_preview
        ),
        MovieData(
            name = resources.getString(R.string.movie6_name),
            name_es = "Gámbito de dama",
            year = "2020 - 2020 16",
            actors = resources.getString(R.string.movie6_actors),
            synopsis = resources.getString(R.string.movie6_synopsis),
            rating = 9.0F,
            thumbnail = R.drawable.queengambit_thumbnail,
            category = "Miniserie de TV",
            numberEpisodes = 7,
            preview = R.drawable.queengambit_preview
        ), MovieData(
            name = resources.getString(R.string.movie7_name),
            name_es = resources.getString(R.string.movie7_name),
            year = "2016 - 2022",
            actors = resources.getString(R.string.movie7_actors),
            synopsis = resources.getString(R.string.movie7_synopsis),
            rating = 9.0F,
            thumbnail = R.drawable.stranger_things_thumbnail,
            category = "Movie",
            numberEpisodes = 9,
            preview = R.drawable.strangerthings_preview
        ), MovieData(
            name = resources.getString(R.string.movie2_name),
            name_es = "MadMax: Furia en la carretera",
            year = "2015",
            actors = resources.getString(R.string.movie2_actors),
            synopsis = resources.getString(R.string.movie2_synopsis),
            rating = 9.0F,
            thumbnail = R.drawable.madmax_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.madmax_preview
        ),
        MovieData(
            name = resources.getString(R.string.movie3_name),
            name_es = "El batman",
            year = "2022",
            actors = resources.getString(R.string.movie3_actors),
            synopsis = resources.getString(R.string.movie3_synopsis),
            rating = 6.5F,
            thumbnail = R.drawable.batman_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.batman_preview
        ),
        MovieData(
            name = resources.getString(R.string.movie4_name),
            name_es = resources.getString(R.string.movie4_name),
            year = "2016",
            actors = resources.getString(R.string.movie4_actors),
            synopsis = resources.getString(R.string.movie4_synopsis),
            rating = 8.0F,
            thumbnail = R.drawable.deadpool_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.deadpool_preview
        ),
        MovieData(
            name = resources.getString(R.string.movie5_name),
            name_es = "Spider-Man: sin camino a casa",
            year = "2021",
            actors = resources.getString(R.string.movie5_actors),
            synopsis = resources.getString(R.string.movie5_synopsis),
            rating = 9.8F,
            thumbnail = R.drawable.spiderman_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.spiderman_preview
        )
    )
}