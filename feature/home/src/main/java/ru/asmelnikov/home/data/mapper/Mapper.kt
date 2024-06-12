package ru.asmelnikov.home.data.mapper

import ru.asmelnikov.home.domain.model.ResultHomeUI
import ru.asmelnikov.home.domain.model.Result

fun Result.toResultHomeUI(): ResultHomeUI {
    return ResultHomeUI(
        id = id,
        posterPath = posterPath,
        title = title
    )
}