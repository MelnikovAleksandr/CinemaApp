package ru.asmelnikov.domain.usecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.domain.repository.UserRepository
import ru.asmelnikov.util.Response

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke() = flow {
        try {
            emit(Response.Loading)
            val querySnapshot = userRepository.getUser().await()
            emit(Response.Success(querySnapshot))
        } catch (e: Exception) {
            emit(
                Response.Error(
                    e.localizedMessage ?: "User Information could not be get from server!"
                )
            )
        }
    }
}