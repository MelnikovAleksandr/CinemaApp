package ru.asmelnikov.detail.data.repository

import ru.asmelnikov.detail.data.model.credit.Credit
import ru.asmelnikov.detail.data.model.detail.MovieDetail
import ru.asmelnikov.detail.data.remote.DetailApiService
import ru.asmelnikov.detail.domain.repository.DetailMovieRepository

class DetailMovieRepositoryImpl (
    private val detailApiService: DetailApiService
) : DetailMovieRepository {
    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        return detailApiService.getMovieDetail(movieId = movieId)
    }

    override suspend fun getCredit(movieId: Int): Credit {
        return detailApiService.getCredit(movieId = movieId)
    }
}