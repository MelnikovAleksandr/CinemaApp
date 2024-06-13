package ru.asmelnikov.detail.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ru.asmelnikov.components.message_bar.BarType
import ru.asmelnikov.components.message_bar.MessageBarContent
import ru.asmelnikov.components.message_bar.rememberAnimatedBarState
import ru.asmelnikov.domain.models.WatchListMovie

@Composable
fun DetailScreen(onNavigateHome: () -> Unit, onNavigateVideo: (String) -> Unit) {
    val viewModel: DetailViewModel = hiltViewModel()
    val barState = rememberAnimatedBarState()
    val state = viewModel.state.value
    val watchListMovie = state.movie?.let {
        WatchListMovie(
            movieId = it.id,
            title = it.title,
            poster = it.backDropPath
        )
    }
    val castList = viewModel.creditList.value
    MessageBarContent(barState = barState, duration = 800L) {
        DetailContent(
            movie = state.movie,
            isLoading = state.isLoading,
            cast = castList,
            onBackClick = onNavigateHome,
            onSaveWatchlistClick = {
                if (watchListMovie != null) {
                    viewModel.saveToWatchlist(
                        movie = watchListMovie,
                        onSuccess = {
                            barState.AnimatedMessageBar(
                                message = "Successfully Added!",
                                type = BarType.SUCCESS
                            )
                        },
                        onError = { msg ->
                            barState.AnimatedMessageBar(
                                message = msg,
                                type = BarType.ERROR
                            )
                        }
                    )
                }
            },
            onWatchClick = { onNavigateVideo(state.movie?.id.toString()) }
        )
    }
}