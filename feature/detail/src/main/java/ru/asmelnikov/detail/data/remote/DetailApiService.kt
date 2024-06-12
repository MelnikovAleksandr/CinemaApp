package ru.asmelnikov.detail.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.asmelnikov.detail.data.model.credit.Credit
import ru.asmelnikov.detail.data.model.detail.MovieDetail
import ru.asmelnikov.util.Constants

interface DetailApiService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = Constants.LANGUAGE,
    ): MovieDetail

    @GET("movie/{movie_id}/credits")
    suspend fun getCredit(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = Constants.LANGUAGE,
    ): Credit
}