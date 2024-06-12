package ru.asmelnikov.profile.data

import com.google.firebase.auth.FirebaseAuth
import ru.asmelnikov.profile.domain.ProfileAuthenticationRepository

class ProfileAuthenticationRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) : ProfileAuthenticationRepository {

    override suspend fun signOut() {
        firebaseAuth.signOut()
    }

}