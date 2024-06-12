package ru.asmelnikov.watchlist.domain.usecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.util.Response
import ru.asmelnikov.watchlist.domain.WatchListRepository

class GetWatchListUseCase(
    val watchListRepository: WatchListRepository
) {
    operator fun invoke() = flow {
        try {
            emit(Response.Loading)
            val querySnapshot = watchListRepository.getMovies().await()

            emit(Response.Success(querySnapshot))

        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        }
    }
}