package ru.inspirationpoint.search.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.inspirationpoint.search.data.datasource.SearchDataSource
import ru.inspirationpoint.search.data.model.SearchResult
import ru.inspirationpoint.search.data.remote.SearchApiService
import ru.inspirationpoint.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchApiService: SearchApiService
) : SearchRepository {

    override  fun searchMovie(searchString: String): Flow<PagingData<SearchResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = 6
            ),
            pagingSourceFactory = {
                SearchDataSource(
                    searchApiService = searchApiService,
                    searchString = searchString
                )
            }
        ).flow
    }
}