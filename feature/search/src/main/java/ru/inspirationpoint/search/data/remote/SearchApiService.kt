package ru.inspirationpoint.search.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.asmelnikov.util.Constants
import ru.inspirationpoint.search.data.model.Search

interface SearchApiService {
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1,
        @Query("query") searchString: String = "",
        @Query("include_adult") adult: Boolean = true,
    ): Search
}