package ru.asmelnikov.domain.usecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.domain.repository.UserRepository
import ru.asmelnikov.util.Response

class GetUserProfileImageUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke() = flow {
        try {
            emit(Response.Loading)
            val result = userRepository.getProfileImage().await()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Profile Image load error"))
        }
    }
}