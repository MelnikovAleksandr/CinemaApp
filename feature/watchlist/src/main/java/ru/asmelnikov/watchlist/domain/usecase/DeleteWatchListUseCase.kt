package ru.asmelnikov.watchlist.domain.usecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.util.Response
import ru.asmelnikov.watchlist.domain.WatchListRepository

class DeleteWatchListUseCase(
    private val watchListRepository: WatchListRepository
) {
    suspend operator fun invoke(movieId: String) = flow {
        try {
            emit(Response.Loading)
            val result = watchListRepository.deleteMovie(movieId).await()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Movie could not be deleted!"))
        }
    }
}