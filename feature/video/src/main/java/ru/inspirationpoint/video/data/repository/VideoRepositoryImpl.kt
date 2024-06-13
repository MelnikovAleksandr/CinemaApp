package ru.inspirationpoint.video.data.repository

import ru.inspirationpoint.video.data.remote.VideoApiService
import ru.inspirationpoint.video.domain.repository.VideoRepository
import ru.inspirationpoint.video.model.MovieVideo

class VideoRepositoryImpl (
    private val videoApiService: VideoApiService
) : VideoRepository {
    override suspend fun getMovieVideo(movieId: Int): MovieVideo {
        return videoApiService.getMovieVideos(movieId = movieId)
    }
}