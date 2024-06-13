package ru.asmelnikov.detail.domain.model

import ru.asmelnikov.detail.data.model.detail.Genre

data class MovieDetailUI (
    val backDropPath: String,
    val genres: List<Genre>,
    val status : String,
    val id: Int,
    val originalLanguage: String,
    val overview: String,
    val releaseDate: String,
    val title: String,
)