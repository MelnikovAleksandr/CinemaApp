package ru.inspirationpoint.video.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.util.Constants.MOVIE_ID
import ru.asmelnikov.util.Screen
import ru.inspirationpoint.video.presentation.VideoScreen

fun NavGraphBuilder.videoScreen(navController: NavController) {
    composable(
        route = Screen.VideoScreen.route + "/{${MOVIE_ID}}",
    ) {
        VideoScreen(
            onNavigateHome = {
                navController.popBackStack()
                navController.navigate(Screen.HomeScreen.route)
            }
        )
    }
}