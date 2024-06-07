package ru.asmelnikov.signup.domain.usecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.signup.domain.repository.AuthenticationRepository
import ru.asmelnikov.util.Response

class SignUpWithEmailAndPasswordUseCase (
    private val authRepository: AuthenticationRepository
) {
    operator fun invoke(email: String, password: String) = flow {
        try {
            emit(Response.Loading)
            emit(Response.Success(authRepository.signUpWithEmailAndPassword(email, password).await()))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        }
    }
}