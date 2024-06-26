package ru.asmelnikov.detail.domain.usecase

data class DetailUseCases (
    val getCastUseCase: GetCastUseCase,
    val getMovieDetailUseCase: GetMovieDetailUseCase,
    val saveMovieToWatchlistUseCase: SaveMovieToWatchlistUseCase
)