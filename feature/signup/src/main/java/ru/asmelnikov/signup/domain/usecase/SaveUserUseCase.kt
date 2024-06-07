package ru.asmelnikov.signup.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.asmelnikov.domain.models.User
import ru.asmelnikov.signup.domain.repository.AuthenticationRepository
import ru.asmelnikov.signup.domain.repository.FirebaseStorageRepository
import ru.asmelnikov.util.Response

class SaveUserUseCase(
    private val firebaseStorageRepository: FirebaseStorageRepository,
    private val authenticationRepository: AuthenticationRepository
) {
    operator fun invoke(user: User) = flow {
        try {
            emit(Response.Loading)
            val userUid = authenticationRepository.getUserUid()
            val result =
                firebaseStorageRepository.saveUser(userUid = userUid, user = user)
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "User could not be saved!"))
        }


    }
}