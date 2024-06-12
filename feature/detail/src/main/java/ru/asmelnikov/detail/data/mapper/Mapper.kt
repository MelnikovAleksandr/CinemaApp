package ru.asmelnikov.detail.data.mapper

import ru.asmelnikov.detail.data.model.credit.Cast
import ru.asmelnikov.detail.data.model.detail.MovieDetail
import ru.asmelnikov.detail.domain.model.CastUI
import ru.asmelnikov.detail.domain.model.MovieDetailUI

fun MovieDetail.toMovieDetailUI(): MovieDetailUI {
    return MovieDetailUI(
        backDropPath = backDropPath,
        genres = genres,
        id = id,
        originalLanguage = originalLanguage,
        overview = overview,
        releaseDate = releaseDate,
        title = title,
        status = status
    )
}

fun Cast.toCastUI(): CastUI {
    return CastUI(
        name = originalName,
        character = character,
        profilePath = profilePath
    )
}