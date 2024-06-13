package ru.inspirationpoint.video.presentation

import ru.inspirationpoint.video.model.MovieVideo

data class VideoUIState(
    var movie: MovieVideo? = null,
    var isLoading: Boolean = false,
    var error: String = ""
)