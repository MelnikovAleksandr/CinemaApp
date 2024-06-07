package ru.asmelnikov.signin.data

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import ru.asmelnikov.signin.domain.AuthenticationRepository

class AuthenticationRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) : AuthenticationRepository {
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }
}