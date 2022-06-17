package com.danielcano.imdbapp.datalayer

import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.datasources.MovieData

fun requestMoviesSource (): List<MovieData> {
    return listOf(
        MovieData(
            name = "Dune",
            name_es = "Duna",
            year = "2022",
            actors = "Timothée Chalamet, Zendaya",
            synopsis = "Película de ciencia ficción con implicaciones geopolíticas y ambientales",
            rating = 8.8F,
            thumbnail = R.drawable.dune_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.dune_preview
        ),
        MovieData(
            name = "The Queens Gambit",
            name_es = "Gámbito de dama",
            year = "2020 - 2020 16",
            actors = "Anya Taylor-Joy, Thomas Brodie-Sangster",
            synopsis = "Ambientada en plena Guerra Fría, Gambito de Dama sigue a Beth Harmon, una huérfana de Kentucky con un increíble don para el ajedrez que lucha contra las adicciones mientras trata de convertirse en la mejor jugadora del mundo. La serie recorre la vida de la joven desde su niñez, cuando aprende a jugar al ajedrez con tan solo ocho años en el orfanato donde se ha criado; hasta su adolescencia, donde la chica prodigio atraviesa torneos regionales y nacionales.",
            rating = 9.0F,
            thumbnail = R.drawable.queengambit_thumbnail,
            category = "Miniserie de TV",
            numberEpisodes = 7,
            preview = R.drawable.queengambit_preview
        ), MovieData(
            name = "Stranger Things",
            name_es = "Stranger Things",
            year = "2016 - 2022",
            actors = "Winona Ryder, Millie Bobby, Finn Wolfhard",
            synopsis = "A raíz de la desaparición de un niño, un pueblo desvela un misterio relacionado con experimentos secretos, fuerzas sobrenaturales aterradoras y una niña muy extraña.",
            rating = 9.0F,
            thumbnail = R.drawable.stranger_things_thumbnail,
            category = "Movie",
            numberEpisodes = 9,
            preview = R.drawable.strangerthings_preview
        ), MovieData(
            name = "MadMax",
            name_es = "MadMax: Furia en la carretera",
            year = "2015",
            actors = "Tom Hardy, Charlize Theron",
            synopsis = "Carrera en un futuro distopico",
            rating = 9.0F,
            thumbnail = R.drawable.madmax_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.madmax_preview
        ),
        MovieData(
            name = "Batman",
            name_es = "El batman",
            year = "2022",
            actors = "Robert Pattinson, Zoë Kravitz",
            synopsis = "Super héroe inteligente y con apariencia de murciélago",
            rating = 6.5F,
            thumbnail = R.drawable.batman_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.batman_preview
        ),
        MovieData(
            name = "Deadpool",
            name_es = "Deadpool",
            year = "2016",
            actors = "Ryan Reynolds, Morena Baccarin, Josh Brolin",
            synopsis = "Locura e inmortalidad se juntan con la comedia",
            rating = 8.0F,
            thumbnail = R.drawable.deadpool_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.deadpool_preview
        ),
        MovieData(
            name = "Spider-Man: No Way Home",
            name_es = "Spider-Man: sin camino a casa",
            year = "2021",
            actors = "Tom Holland, Benedict Cumberbatch, Tobey Maguire",
            synopsis = "Un chico con traje de lencería intentando salvar el mundo",
            rating = 9.8F,
            thumbnail = R.drawable.spiderman_thumbnail,
            category = "Movie",
            numberEpisodes = 1,
            preview = R.drawable.spiderman_preview
        )
    )
}