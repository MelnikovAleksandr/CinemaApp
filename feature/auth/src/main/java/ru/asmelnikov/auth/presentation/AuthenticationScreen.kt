package ru.asmelnikov.auth.presentation

import androidx.compose.runtime.Composable

@Composable
fun AuthenticationScreen(
    onNavigateSignInClick: () -> Unit,
) {
    AuthenticationContent(
        onNavigateSignInClick = onNavigateSignInClick,
    )
}