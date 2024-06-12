package ru.asmelnikov.signup.data

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import ru.asmelnikov.domain.models.User
import ru.asmelnikov.signup.domain.repository.FirebaseStorageRepository
import ru.asmelnikov.util.Constants.USER_COLLECTION

class FirebaseStorageRepositoryImpl(
    private val firebaseFirestore: FirebaseFirestore,
) : FirebaseStorageRepository {
    override suspend fun saveUser(
        userUid: String,
        user: User
    ): Task<DocumentReference?> {
        return firebaseFirestore.collection(USER_COLLECTION).document(userUid).collection("info").add(user)
    }
}