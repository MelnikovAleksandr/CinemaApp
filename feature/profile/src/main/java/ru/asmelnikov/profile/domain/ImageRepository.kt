package ru.asmelnikov.profile.domain

import android.net.Uri
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.UploadTask

interface ImageRepository {
    suspend fun saveProfileImage(imageUrl: String): Task<Void?>
    suspend fun uploadProfileImage(image: Uri): UploadTask
    suspend fun getUserUid(): String

}