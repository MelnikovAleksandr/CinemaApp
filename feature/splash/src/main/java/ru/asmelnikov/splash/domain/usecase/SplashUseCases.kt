package ru.asmelnikov.splash.domain.usecase

data class SplashUseCases(
    val isSignedInUseCase: IsSignedInUseCase,
    val readOnBoardingStateUseCase: ReadOnBoardingStateUseCase
)