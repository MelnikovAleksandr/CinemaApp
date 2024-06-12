package ru.asmelnikov.profile.domain

interface ProfileAuthenticationRepository {
    suspend fun signOut()
}