package ru.asmelnikov.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import ru.asmelnikov.components.message_bar.BarType
import ru.asmelnikov.components.message_bar.MessageBarContent
import ru.asmelnikov.components.message_bar.rememberAnimatedBarState
import ru.asmelnikov.util.Constants.EMPTY_IMAGE

@Composable
fun ProfileScreen(onNavigateAuthentication: () -> Unit) {
    val barState = rememberAnimatedBarState()
    val viewModel: ProfileViewModel = hiltViewModel()
    val state = viewModel.state.value
    val image = viewModel.imageState.value
    val isUploading = viewModel.uploadState.value

    var signedOutState by remember {
        mutableStateOf(false)
    }
    if (signedOutState) {
        LaunchedEffect(key1 = Unit) {
            delay(600)
            onNavigateAuthentication()
        }
    }
    MessageBarContent(barState = barState) {
        ProfileContent(
            user = state.user,
            profileImage = image ?: EMPTY_IMAGE,
            isPhotoUploading = isUploading,
            onSaveProfileImage = { uri ->
                if (uri != null) {
                    viewModel.uploadProfileImage(image = uri,
                        onSuccess = {
                            barState.AnimatedMessageBar(
                                message = "Profile Photo Successfully Uploaded!",
                                type = BarType.SUCCESS
                            )
                        },
                        onError = { msg ->
                            barState.AnimatedMessageBar(
                                message = msg,
                                type = BarType.ERROR
                            )
                        })
                }
            },
            onSignOutClick = {
                viewModel.signOut(
                    onSuccess = {
                        barState.AnimatedMessageBar(
                            message = "Successfully Signed Out!",
                            type = BarType.SUCCESS
                        )
                    },
                    onError = { msg ->
                        barState.AnimatedMessageBar(
                            message = msg,
                            type = BarType.ERROR
                        )
                    }
                )
                signedOutState = true
            }
        )
    }

}
