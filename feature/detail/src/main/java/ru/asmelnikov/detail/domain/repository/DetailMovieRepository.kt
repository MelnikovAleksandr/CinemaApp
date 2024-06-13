package ru.asmelnikov.detail.domain.repository

import ru.asmelnikov.detail.data.model.credit.Credit
import ru.asmelnikov.detail.data.model.detail.MovieDetail


interface DetailMovieRepository {

    suspend fun getCredit(movieId : Int) : Credit

    suspend fun getMovieDetail(movieId : Int) : MovieDetail

}