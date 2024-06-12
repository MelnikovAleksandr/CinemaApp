package ru.asmelnikov.watchlist.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.util.Screen
import ru.asmelnikov.watchlist.presentation.WatchListScreen

fun NavGraphBuilder.watchList(navController: NavController) {
    composable(Screen.WatchListScreen.route) {
        WatchListScreen(
            onNavigateDetail = { id ->
                navController.popBackStack()
                navController.navigate(Screen.DetailScreen.route + "/${id}")
            }
        )
    }
}