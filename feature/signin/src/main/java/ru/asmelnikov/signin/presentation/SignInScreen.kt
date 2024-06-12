package ru.asmelnikov.signin.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ru.asmelnikov.components.message_bar.BarType
import ru.asmelnikov.components.message_bar.MessageBarContent
import ru.asmelnikov.components.message_bar.rememberAnimatedBarState

@Composable
fun SignInScreen(
    onNavigateSignUp: () -> Unit,
    onNavigateHome: () -> Unit
) {
    val viewModel: SignInViewModel = hiltViewModel()
    val state = viewModel.state
    val barState = rememberAnimatedBarState()

    MessageBarContent(barState = barState) {
        SignInContent(
            isLoading = state.isLoading,
            isAuthenticated = state.isAuthenticated,
            onNavigateSignUp = onNavigateSignUp,
            onNavigateHome = onNavigateHome,
            onSignInClick = { mail, password ->
                viewModel.signInWithEmailAndPassword(
                    email = mail,
                    password = password,
                    onError = { msg ->
                        barState.AnimatedMessageBar(
                            message = msg,
                            type = BarType.ERROR
                        )
                    },
                    onSuccess = {
                        barState.AnimatedMessageBar(
                            message = "Successfully Signed In!",
                            type = BarType.SUCCESS
                        )
                    }
                )
            })
    }
}