package ru.asmelnikov.watchlist.domain.usecase

data class WatchListUseCases (
    val deleteWatchListUseCase: DeleteWatchListUseCase,
    val getWatchListUseCase: GetWatchListUseCase
)