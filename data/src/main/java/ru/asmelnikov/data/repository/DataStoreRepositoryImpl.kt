package ru.asmelnikov.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import ru.asmelnikov.domain.repository.DataStoreRepository
import ru.asmelnikov.util.Constants
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.DATASTORE_PREFERENCES_NAME)

class DataStoreRepositoryImpl(private val context: Context) : DataStoreRepository {

    private val dataStore = context.dataStore
    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.edit {
            it[Constants.DATASTORE_PREFERENCES_KEY] = isCompleted
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { value ->
                val state = value[Constants.DATASTORE_PREFERENCES_KEY] ?: false
                state
            }
    }

}