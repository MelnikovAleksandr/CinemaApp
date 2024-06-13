package ru.inspirationpoint.video.domain.repository

import ru.inspirationpoint.video.model.MovieVideo

interface VideoRepository {
    suspend fun getMovieVideo(movieId : Int) : MovieVideo

}