package ru.asmelnikov.cinemaapp.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.asmelnikov.data.repository.DataStoreRepositoryImpl
import ru.asmelnikov.data.repository.UserRepositoryImpl
import ru.asmelnikov.domain.repository.DataStoreRepository
import ru.asmelnikov.domain.repository.UserRepository
import ru.asmelnikov.home.data.remote.ApiService
import ru.asmelnikov.home.data.repository.MovieRepositoryImpl
import ru.asmelnikov.home.domain.repository.MovieRepository
import ru.asmelnikov.profile.data.ImageRepositoryImpl
import ru.asmelnikov.profile.data.ProfileAuthenticationRepositoryImpl
import ru.asmelnikov.profile.domain.ImageRepository
import ru.asmelnikov.profile.domain.ProfileAuthenticationRepository
import ru.asmelnikov.signup.data.FirebaseStorageRepositoryImpl
import ru.asmelnikov.signup.domain.repository.FirebaseStorageRepository
import ru.asmelnikov.splash.data.SplashAuthRepositoryImpl
import ru.asmelnikov.splash.domain.repository.SplashAuthRepository
import ru.asmelnikov.watchlist.data.WatchListRepositoryImpl
import ru.asmelnikov.watchlist.domain.WatchListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSignInAuthenticationRepository(firebaseAuth: FirebaseAuth): ru.asmelnikov.signin.domain.AuthenticationRepository {
        return ru.asmelnikov.signin.data.AuthenticationRepositoryImpl(
            firebaseAuth = firebaseAuth
        )
    }

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

    @Provides
    @Singleton
    fun provideAuthenticationRepository(firebaseAuth: FirebaseAuth): ru.asmelnikov.signup.domain.repository.AuthenticationRepository {
        return ru.asmelnikov.signup.data.AuthenticationRepositoryImpl(firebaseAuth = firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: ApiService): MovieRepository {
        return MovieRepositoryImpl(apiService = apiService)
    }


    @Provides
    @Singleton
    fun provideFirebaseStorageRepository(
        firebaseFirestore: FirebaseFirestore,
    ): FirebaseStorageRepository {
        return FirebaseStorageRepositoryImpl(
            firebaseFirestore = firebaseFirestore,
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        firebaseFirestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth
    ): UserRepository {
        return UserRepositoryImpl(
            firebaseFirestore = firebaseFirestore,
            firebaseAuth = firebaseAuth
        )
    }

    @Provides
    @Singleton
    fun provideProfileAuthenticationRepository(firebaseAuth: FirebaseAuth): ProfileAuthenticationRepository {
        return ProfileAuthenticationRepositoryImpl(firebaseAuth = firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideImageRepository(
        firebaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore,
        firebaseStorage: FirebaseStorage
    ): ImageRepository {
        return ImageRepositoryImpl(
            firebaseAuth = firebaseAuth,
            firebaseFirestore = firebaseFirestore,
            firebaseStorage = firebaseStorage
        )
    }

    @Provides
    @Singleton
    fun provideWatchListRepository(
        firebaseFirestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth
    ): WatchListRepository {
        return WatchListRepositoryImpl(
            firebaseFirestore = firebaseFirestore,
            firebaseAuth = firebaseAuth
        )
    }

}