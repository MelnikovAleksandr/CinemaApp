package ru.asmelnikov.home.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.home.domain.model.Result
import ru.asmelnikov.home.domain.repository.MovieRepository


class GetNowPlayingMovieUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<Result>> {
        return movieRepository.getNowPlayingMovies()
    }
}