package ru.inspirationpoint.video.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.asmelnikov.util.Response
import ru.inspirationpoint.video.domain.repository.VideoRepository
import javax.inject.Inject

class GetMovieVideoUseCase @Inject constructor(
    private val videoRepository: VideoRepository
) {
    operator fun invoke(movieId: Int) = flow {
        try {
            emit(Response.Loading)
            val result = videoRepository.getMovieVideo(movieId = movieId)
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        }
    }
}