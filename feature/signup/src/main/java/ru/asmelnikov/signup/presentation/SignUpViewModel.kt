package ru.asmelnikov.signup.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.asmelnikov.domain.models.User
import ru.asmelnikov.signup.domain.usecase.SignUpUseCases
import ru.asmelnikov.util.Response
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val useCase: SignUpUseCases
) : ViewModel() {


    var loadingState by mutableStateOf(false)
        private set

    private fun setLoading(isLoading: Boolean) {
        loadingState = isLoading
    }

    fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        useCase.signUpWithEmailAndPasswordUseCase.invoke(email, password)
            .onEach { result ->
                when (result) {
                    is Response.Success -> {
                        onSuccess()
                        setLoading(isLoading = false)
                    }

                    is Response.Loading -> {
                        setLoading(isLoading = true)
                    }

                    is Response.Error -> {
                        onError(result.errorMessage)
                        setLoading(isLoading = false)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun saveUser(
        name: String,
        email: String,
        onError: (String) -> Unit,
        onSuccess: () -> Unit
    ) {
        useCase.saveUserUseCase.invoke(user = User(name = name, email = email))
            .onEach { response ->
                when (response) {
                    is Response.Success -> {
                        onSuccess()
                    }

                    is Response.Error -> {
                        onError(response.errorMessage)
                    }

                    else -> {
                    }
                }
            }.launchIn(viewModelScope)
    }
}