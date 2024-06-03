package ru.asmelnikov.cinemaapp.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.asmelnikov.data.repository.DataStoreRepositoryImpl
import ru.asmelnikov.domain.repository.DataStoreRepository
import ru.asmelnikov.splash.data.SplashAuthRepositoryImpl
import ru.asmelnikov.splash.domain.repository.SplashAuthRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideSplashAuthRepository(firebaseAuth: FirebaseAuth): SplashAuthRepository {
        return SplashAuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository {
        return DataStoreRepositoryImpl(context = context)
    }

}