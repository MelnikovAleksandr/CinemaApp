package ru.asmelnikov.profile.domain.usecase

data class ProfileUseCases(
    val saveUserProfileImageUseCase: SaveUserProfileImageUseCase,
    val uploadProfileImageUseCase: UploadProfileImageUseCase,
    val signOutUseCase: SignOutUseCase
)