package ru.asmelnikov.splash.domain.repository

interface SplashAuthRepository {
    suspend fun isSignedIn(): Boolean
}