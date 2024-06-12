package ru.asmelnikov.profile.presentation

import ru.asmelnikov.domain.models.User

data class ProfileUIState(
    var user: User = User(),
    var isImageUploading : Boolean = false,
    var isLoading : Boolean = false,
    var error : String = ""
)