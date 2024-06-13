package ru.inspirationpoint.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.inspirationpoint.search.data.mapper.toSearchUI
import ru.inspirationpoint.search.domain.model.SearchUI
import ru.inspirationpoint.search.domain.usecase.SearchMovieUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
) : ViewModel() {

    var searchedMovieList: MutableStateFlow<PagingData<SearchUI>> =
        MutableStateFlow(value = PagingData.empty())
        private set

    private fun searchMovie(searchString: String) {
        searchMovieUseCase.invoke(searchString)
            .cachedIn(viewModelScope)
            .onEach { searchResult ->
                searchedMovieList.value = searchResult.map { it.toSearchUI() }
            }
            .launchIn(viewModelScope)
    }

    fun onSearchEvent(searchString: String) {
        searchMovie(searchString = searchString)
    }
}