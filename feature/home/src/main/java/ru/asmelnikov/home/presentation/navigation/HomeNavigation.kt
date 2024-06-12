package ru.asmelnikov.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.home.presentation.HomeScreen
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(Screen.HomeScreen.route) {
        HomeScreen(
            onNavigateDetailScreen = { id ->
                navController.navigate(Screen.DetailScreen.route + "/${id}")
            }
        )
    }
}