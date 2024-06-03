package ru.asmelnikov.splash.data

import com.google.firebase.auth.FirebaseAuth
import ru.asmelnikov.splash.domain.repository.SplashAuthRepository

class SplashAuthRepositoryImpl (private val firebaseAuth: FirebaseAuth): SplashAuthRepository {

    override suspend fun isSignedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }
}