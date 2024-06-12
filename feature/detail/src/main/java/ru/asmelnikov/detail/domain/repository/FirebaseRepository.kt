package ru.asmelnikov.detail.domain.repository

import com.google.android.gms.tasks.Task
import ru.asmelnikov.domain.models.WatchListMovie

interface FirebaseRepository {
    suspend fun getUserUid(): String
    suspend fun saveMovie(movie: WatchListMovie): Task<Void?>

}