package ru.asmelnikov.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.auth.presentation.AuthenticationScreen
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.authenticationScreen(navController: NavController) {
    composable(route = Screen.AuthenticationScreen.route) {
        AuthenticationScreen(
            onNavigateSignInClick = { navController.navigate(Screen.SignInScreen.route) },
        )
    }
}