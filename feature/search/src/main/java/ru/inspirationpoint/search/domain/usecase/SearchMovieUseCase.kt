package ru.inspirationpoint.search.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.inspirationpoint.search.data.model.SearchResult
import ru.inspirationpoint.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
     operator fun invoke(searchString: String): Flow<PagingData<SearchResult>> {
        return searchRepository.searchMovie(searchString)
    }
}