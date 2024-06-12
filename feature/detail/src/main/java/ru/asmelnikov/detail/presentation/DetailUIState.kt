package ru.asmelnikov.detail.presentation

import ru.asmelnikov.detail.domain.model.MovieDetailUI

data class DetailUIState(
    var movie : MovieDetailUI? = null,
    var isLoading : Boolean = false,
    var error : String = ""
)