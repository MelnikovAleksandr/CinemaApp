package ru.asmelnikov.splash.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.splash.presentation.SplashScreen
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.splashScreen(navController: NavController) {

    composable(route = Screen.SplashScreen.route) {
        SplashScreen(
            onNavigateAuthenticationScreen = {
                navController.popBackStack()
                navController.navigate(Screen.AuthenticationScreen.route)
            },
            onNavigateHomeScreen = {
                navController.popBackStack()
                navController.navigate(Screen.HomeScreen.route)
            },
            onNavigateOnBoardingScreen = {
                navController.popBackStack()
                navController.navigate(Screen.OnBoardingScreen.route)
            }
        )
    }
}