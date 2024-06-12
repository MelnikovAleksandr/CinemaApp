package ru.asmelnikov.watchlist.presentation

import ru.asmelnikov.domain.models.WatchListMovie

data class WatchListUIState (
    val movie : List<WatchListMovie> = listOf(),
    var loading : Boolean = false,
    var error : String = ""
)