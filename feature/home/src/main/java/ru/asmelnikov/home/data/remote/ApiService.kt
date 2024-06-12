package ru.asmelnikov.home.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.asmelnikov.home.data.model.Movie
import ru.asmelnikov.util.Constants

interface ApiService {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = Constants.LANGUAGE,
        @Query("page") page: Int = 1
    ): Movie

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = Constants.LANGUAGE,
        @Query("page") page: Int = 1
    ): Movie

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = Constants.LANGUAGE,
        @Query("page") page: Int = 1
    ): Movie
}