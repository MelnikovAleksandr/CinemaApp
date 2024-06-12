package ru.asmelnikov.cinemaapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import ru.asmelnikov.auth.navigation.authenticationScreen
import ru.asmelnikov.detail.presentation.navigation.detailScreen
import ru.asmelnikov.home.presentation.navigation.homeScreen
import ru.asmelnikov.onboarding.presentation.navigation.onBoardingScreen
import ru.asmelnikov.profile.presentation.navigation.profile
import ru.asmelnikov.signin.presentation.navigation.signInScreen
import ru.asmelnikov.signup.presentation.navigation.signUpScreen
import ru.asmelnikov.splash.presentation.navigation.splashScreen
import ru.asmelnikov.util.Screen
import ru.asmelnikov.watchlist.presentation.navigation.watchList


@Composable
fun NavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        splashScreen(navController = navController)
        authenticationScreen(navController = navController)
        onBoardingScreen(navController = navController)
        signInScreen(navController = navController)
        signUpScreen(navController = navController)
        homeScreen(navController = navController)
        profile(navController = navController)
        watchList(navController = navController)
        detailScreen(navController = navController)
    }
}