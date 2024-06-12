package ru.asmelnikov.detail.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.asmelnikov.detail.domain.repository.DetailMovieRepository
import ru.asmelnikov.util.Response
import ru.asmelnikov.detail.data.mapper.toCastUI

class GetCastUseCase(
    val detailMovieRepository: DetailMovieRepository
) {
    operator fun invoke(movieId: Int) = flow {
        try {
            emit(Response.Loading)
            val result = detailMovieRepository.getCredit(movieId = movieId).cast.map { it.toCastUI() }
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        }
    }
}