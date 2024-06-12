package ru.asmelnikov.home.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.home.domain.repository.MovieRepository
import ru.asmelnikov.home.domain.model.Result

class GetPopularMovieUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<Result>> {
        return movieRepository.getPopularMovies()
    }
}