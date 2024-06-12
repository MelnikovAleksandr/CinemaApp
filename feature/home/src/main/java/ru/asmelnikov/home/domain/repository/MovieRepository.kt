package ru.asmelnikov.home.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.asmelnikov.home.domain.model.Result


interface MovieRepository {

    fun getTopRatedMovies() : Flow<PagingData<Result>>

    fun getPopularMovies() : Flow<PagingData<Result>>

    fun getNowPlayingMovies() : Flow<PagingData<Result>>
}