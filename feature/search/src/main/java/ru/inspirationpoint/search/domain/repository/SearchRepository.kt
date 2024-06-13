package ru.inspirationpoint.search.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.inspirationpoint.search.data.model.SearchResult

interface SearchRepository {
     fun searchMovie(searchString : String) : Flow<PagingData<SearchResult>>

}