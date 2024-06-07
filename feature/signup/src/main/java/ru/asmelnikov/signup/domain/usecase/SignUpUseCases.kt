package ru.asmelnikov.signup.domain.usecase

data class SignUpUseCases(
    val signUpWithEmailAndPasswordUseCase: SignUpWithEmailAndPasswordUseCase,
    val saveUserUseCase: SaveUserUseCase
)
