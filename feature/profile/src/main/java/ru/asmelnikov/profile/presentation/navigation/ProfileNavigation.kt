package ru.asmelnikov.profile.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.profile.presentation.ProfileScreen
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.profile(navController: NavController) {
    composable(Screen.ProfileScreen.route) {
        ProfileScreen(
            onNavigateAuthentication = {
                navController.popBackStack()
                navController.navigate(Screen.AuthenticationScreen.route)
            })
    }
}