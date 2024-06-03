package ru.asmelnikov.cinemaapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.asmelnikov.domain.repository.DataStoreRepository
import ru.asmelnikov.splash.domain.repository.SplashAuthRepository
import ru.asmelnikov.splash.domain.usecase.IsSignedInUseCase
import ru.asmelnikov.splash.domain.usecase.ReadOnBoardingStateUseCase
import ru.asmelnikov.splash.domain.usecase.SplashUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSplashUseCases(
        dataStoreRepository: DataStoreRepository,
        splashAuthRepository: SplashAuthRepository
    ): SplashUseCases {
        return SplashUseCases(
            isSignedInUseCase = IsSignedInUseCase(
                splashAuthRepository = splashAuthRepository
            ),
            readOnBoardingStateUseCase = ReadOnBoardingStateUseCase(
                dataStoreRepository = dataStoreRepository
            )
        )
    }
}