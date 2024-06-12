package ru.asmelnikov.profile.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.asmelnikov.profile.domain.ProfileAuthenticationRepository
import ru.asmelnikov.util.Response

class SignOutUseCase(
    private val authenticationRepository: ProfileAuthenticationRepository
) {
    suspend operator fun invoke() = flow{
        try {
            emit(Response.Loading)
            val result = authenticationRepository.signOut()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Unexpected Error!"))
        }
    }
}