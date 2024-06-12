package ru.asmelnikov.profile.domain.usecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.profile.domain.ImageRepository
import ru.asmelnikov.util.Response

class SaveUserProfileImageUseCase(
    private val imageRepository: ImageRepository
) {
    operator fun invoke(imageUrl: String) = flow {
        try {
            emit(Response.Loading)
            val result = imageRepository.saveProfileImage(imageUrl = imageUrl).await()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Photo could not be saved!"))
        }
    }
}