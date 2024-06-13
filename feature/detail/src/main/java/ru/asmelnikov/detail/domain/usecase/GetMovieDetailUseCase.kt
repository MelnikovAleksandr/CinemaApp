package ru.asmelnikov.detail.domain.usecase

import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.asmelnikov.detail.domain.repository.DetailMovieRepository
import ru.asmelnikov.util.Response
import ru.asmelnikov.detail.data.mapper.toMovieDetailUI

class GetMovieDetailUseCase(
    val detailMovieRepository: DetailMovieRepository
) {
    operator fun invoke(movieId: Int) = flow {
        return@flow try {
            emit(Response.Loading)
            val result = detailMovieRepository.getMovieDetail(movieId = movieId).toMovieDetailUI()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        } catch (e: HttpException) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        }
    }
}