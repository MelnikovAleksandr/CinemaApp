package ru.asmelnikov.splash.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.asmelnikov.splash.domain.repository.SplashAuthRepository

class IsSignedInUseCase(
    private val splashAuthRepository: SplashAuthRepository
) {
    operator fun invoke() = flow {
        emit(splashAuthRepository.isSignedIn())
    }
}