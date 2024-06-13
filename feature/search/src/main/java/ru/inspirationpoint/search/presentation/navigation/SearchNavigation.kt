package ru.inspirationpoint.search.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.util.Screen
import ru.inspirationpoint.search.presentation.SearchScreen

fun NavGraphBuilder.searchScreen(navController: NavController) {
    composable(Screen.SearchScreen.route) {
        SearchScreen(
            onNavigateDetailScreen = { id ->
                navController.popBackStack()
                navController.navigate(Screen.DetailScreen.route + "/${id}")
            }
        )
    }
}