package ru.asmelnikov.cinemaapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import ru.asmelnikov.auth.navigation.authenticationScreen
import ru.asmelnikov.util.Screen


@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        authenticationScreen(navController = navController)

    }
}