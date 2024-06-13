package ru.asmelnikov.detail.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.asmelnikov.detail.domain.model.CastUI
import ru.asmelnikov.detail.domain.usecase.DetailUseCases
import ru.asmelnikov.util.Constants.MOVIE_ID
import ru.asmelnikov.util.Response
import ru.asmelnikov.domain.models.WatchListMovie
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCases: DetailUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state: MutableState<DetailUIState> = mutableStateOf(DetailUIState())
        private set

    var creditList: MutableState<List<CastUI>> = mutableStateOf(listOf())
        private set

    init {
        savedStateHandle.get<String>(MOVIE_ID)?.let {
            loadMovie(movieId = it.toInt())
            loadCast(movieId = it.toInt())
            println("MOVIE ID $it")
        }
    }

    private fun loadMovie(movieId: Int) {
        useCases.getMovieDetailUseCase.invoke(movieId = movieId).onEach { response ->
            when (response) {
                is Response.Success -> {
                    state.value = DetailUIState(movie = response.data)
                    println("Movie ${response.data}")
                }

                is Response.Loading -> {
                    state.value = DetailUIState(isLoading = true)
                }

                is Response.Error -> {
                    state.value = DetailUIState(error = response.errorMessage)
                }
            }

        }.launchIn(viewModelScope)
    }

    private fun loadCast(movieId: Int) {
        useCases.getCastUseCase.invoke(movieId = movieId).onEach { response ->
            when (response) {
                is Response.Success -> {
                    val cast = response.data
                    creditList.value = cast
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun saveToWatchlist(movie: WatchListMovie, onSuccess: () -> Unit, onError: (String) -> Unit) {

        useCases.saveMovieToWatchlistUseCase(movie = movie).onEach { response ->
            when (response) {
                is Response.Success<*> -> {
                    onSuccess()
                }

                is Response.Loading -> {

                }

                is Response.Error -> {
                    onError(response.errorMessage)
                }
            }

        }.launchIn(viewModelScope)
    }

}