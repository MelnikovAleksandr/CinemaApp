package ru.asmelnikov.signin.domain

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthenticationRepository {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult>
}