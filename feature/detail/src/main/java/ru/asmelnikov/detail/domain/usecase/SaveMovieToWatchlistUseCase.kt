package ru.asmelnikov.detail.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.asmelnikov.detail.domain.repository.FirebaseRepository
import ru.asmelnikov.domain.models.WatchListMovie
import ru.asmelnikov.util.Response

class SaveMovieToWatchlistUseCase(
    val firebaseRepository: FirebaseRepository,
) {
    operator fun invoke(movie: WatchListMovie) = flow {
        try {
            emit(Response.Loading)
            val result = firebaseRepository.saveMovie(movie = movie)
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Error(e.localizedMessage ?: "Could not be saved!"))
        }
    }
}