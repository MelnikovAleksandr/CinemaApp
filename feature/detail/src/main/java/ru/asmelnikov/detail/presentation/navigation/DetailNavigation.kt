package ru.asmelnikov.detail.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.detail.presentation.DetailScreen
import ru.asmelnikov.util.Constants.MOVIE_ID
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.detailScreen(navController: NavController) {
    composable(route = Screen.DetailScreen.route + "/{${MOVIE_ID}}") {
        DetailScreen(
            onNavigateHome = {
                navController.navigate(Screen.HomeScreen.route)
            },
            onNavigateVideo = { id ->
                navController.popBackStack()
                navController.navigate(Screen.VideoScreen.route + "/${id}")
            }
        )
    }
}