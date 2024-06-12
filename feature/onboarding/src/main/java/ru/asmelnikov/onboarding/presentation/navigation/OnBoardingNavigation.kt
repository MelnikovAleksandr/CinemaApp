package ru.asmelnikov.onboarding.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.onboarding.presentation.OnBoardingScreen
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.onBoardingScreen(navController: NavController) {
    composable(route = Screen.OnBoardingScreen.route) {
        OnBoardingScreen(
            onNavigateAuthenticationScreen = { navController.navigate(Screen.AuthenticationScreen.route) }
        )
    }
}