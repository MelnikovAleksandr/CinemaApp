package ru.asmelnikov.signin.presentation

data class SignInUIState(
    val isLoading : Boolean = false,
    val isAuthenticated : Boolean = false,
)