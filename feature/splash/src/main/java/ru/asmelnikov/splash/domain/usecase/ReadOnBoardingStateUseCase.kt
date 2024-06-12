package ru.asmelnikov.splash.domain.usecase

import ru.asmelnikov.domain.repository.DataStoreRepository

class ReadOnBoardingStateUseCase(
    private val dataStoreRepository: DataStoreRepository
) {

    operator fun invoke() = dataStoreRepository.readOnBoardingState()
}