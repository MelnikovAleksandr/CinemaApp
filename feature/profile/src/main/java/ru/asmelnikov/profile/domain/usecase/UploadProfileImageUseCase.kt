package ru.asmelnikov.profile.domain.usecase

import android.net.Uri
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import ru.asmelnikov.profile.domain.ImageRepository
import ru.asmelnikov.util.Response

class UploadProfileImageUseCase(
    private val imageRepository: ImageRepository
) {
    operator fun invoke(image : Uri) = flow {
        try {
            emit(Response.Loading)
            val result = imageRepository.uploadProfileImage(image).await()
            emit(Response.Success(result))
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "Image could not be uploaded!"))
        }
    }
}