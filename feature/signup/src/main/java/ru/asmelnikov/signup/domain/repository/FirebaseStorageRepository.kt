package ru.asmelnikov.signup.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import ru.asmelnikov.domain.models.User

interface FirebaseStorageRepository {

    suspend fun saveUser(
        userUid: String,
        user: User
    ): Task<DocumentReference?>

}