package ru.asmelnikov.signup.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.asmelnikov.signup.presentation.SignUpScreen
import ru.asmelnikov.util.Screen

fun NavGraphBuilder.signUpScreen(navController: NavController) {
    composable(Screen.SignUpScreen.route) {
        SignUpScreen(
            onNavigateSignIn = { navController.navigate(Screen.SignInScreen.route) }
        )
    }
}