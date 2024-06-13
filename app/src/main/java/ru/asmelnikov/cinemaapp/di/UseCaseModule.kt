package ru.asmelnikov.cinemaapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.asmelnikov.detail.domain.repository.DetailMovieRepository
import ru.asmelnikov.detail.domain.repository.FirebaseRepository
import ru.asmelnikov.detail.domain.usecase.DetailUseCases
import ru.asmelnikov.detail.domain.usecase.GetCastUseCase
import ru.asmelnikov.detail.domain.usecase.GetMovieDetailUseCase
import ru.asmelnikov.detail.domain.usecase.SaveMovieToWatchlistUseCase
import ru.asmelnikov.domain.repository.DataStoreRepository
import ru.asmelnikov.domain.repository.UserRepository
import ru.asmelnikov.domain.usecase.GetUserProfileImageUseCase
import ru.asmelnikov.domain.usecase.GetUserUseCase
import ru.asmelnikov.domain.usecase.UseCases
import ru.asmelnikov.home.domain.repository.MovieRepository
import ru.asmelnikov.home.domain.usecase.GetNowPlayingMovieUseCase
import ru.asmelnikov.home.domain.usecase.GetPopularMovieUseCase
import ru.asmelnikov.home.domain.usecase.GetTopRatedMovieUseCase
import ru.asmelnikov.home.domain.usecase.HomeUseCases
import ru.asmelnikov.profile.domain.ImageRepository
import ru.asmelnikov.profile.domain.ProfileAuthenticationRepository
import ru.asmelnikov.profile.domain.usecase.ProfileUseCases
import ru.asmelnikov.profile.domain.usecase.SaveUserProfileImageUseCase
import ru.asmelnikov.profile.domain.usecase.SignOutUseCase
import ru.asmelnikov.profile.domain.usecase.UploadProfileImageUseCase
import ru.asmelnikov.signup.domain.repository.AuthenticationRepository
import ru.asmelnikov.signup.domain.repository.FirebaseStorageRepository
import ru.asmelnikov.signup.domain.usecase.SaveUserUseCase
import ru.asmelnikov.signup.domain.usecase.SignUpUseCases
import ru.asmelnikov.signup.domain.usecase.SignUpWithEmailAndPasswordUseCase
import ru.asmelnikov.splash.domain.repository.SplashAuthRepository
import ru.asmelnikov.splash.domain.usecase.IsSignedInUseCase
import ru.asmelnikov.splash.domain.usecase.ReadOnBoardingStateUseCase
import ru.asmelnikov.splash.domain.usecase.SplashUseCases
import ru.asmelnikov.watchlist.domain.WatchListRepository
import ru.asmelnikov.watchlist.domain.usecase.DeleteWatchListUseCase
import ru.asmelnikov.watchlist.domain.usecase.GetWatchListUseCase
import ru.asmelnikov.watchlist.domain.usecase.WatchListUseCases
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
    @Provides
    @Singleton
    fun provideHomeUseCases(
        movieRepository: MovieRepository,
    ): HomeUseCases {
        return HomeUseCases(
            getNowPlayingMovieUseCase = GetNowPlayingMovieUseCase(
                movieRepository = movieRepository
            ),
            getPopularMovieUseCase = GetPopularMovieUseCase(
                movieRepository = movieRepository
            ),
            getTopRatedMovieUseCase = GetTopRatedMovieUseCase(
                movieRepository = movieRepository
            )
        )
    }

    @Singleton
    @Provides
    fun provideSignUpUseCases(
        authenticationRepository: AuthenticationRepository,
        firebaseStorageRepository: FirebaseStorageRepository
    ): SignUpUseCases {
        return SignUpUseCases(
            signUpWithEmailAndPasswordUseCase = SignUpWithEmailAndPasswordUseCase(
                authRepository = authenticationRepository
            ),
            saveUserUseCase = SaveUserUseCase(
                firebaseStorageRepository = firebaseStorageRepository,
                authenticationRepository = authenticationRepository
            ),
        )
    }

    @Provides
    @Singleton
    fun provideUseCase(
        userRepository: UserRepository,
    ): UseCases {
        return UseCases(
            getUserUseCase = GetUserUseCase(userRepository = userRepository),
            getUserProfileImageUseCase = GetUserProfileImageUseCase(userRepository = userRepository),
        )
    }

    @Provides
    @Singleton
    fun provideProfileUseCases(
        imageRepository: ImageRepository,
        profileAuthenticationRepository: ProfileAuthenticationRepository
    ): ProfileUseCases {
        return ProfileUseCases(
            uploadProfileImageUseCase = UploadProfileImageUseCase(
                imageRepository = imageRepository
            ),
            saveUserProfileImageUseCase = SaveUserProfileImageUseCase(
                imageRepository = imageRepository
            ),
            signOutUseCase = SignOutUseCase(
                authenticationRepository = profileAuthenticationRepository
            )
        )
    }

    @Singleton
    @Provides
    fun provideWatchListUseCases(watchListRepository: WatchListRepository): WatchListUseCases {
        return WatchListUseCases(
            deleteWatchListUseCase = DeleteWatchListUseCase(
                watchListRepository = watchListRepository
            ),
            getWatchListUseCase = GetWatchListUseCase(
                watchListRepository = watchListRepository
            )
        )
    }

    @Provides
    @Singleton
    fun provideDetailUseCases(
        detailMovieRepository: DetailMovieRepository,
        firebaseRepository: FirebaseRepository
    ): DetailUseCases {
        return DetailUseCases(
            getCastUseCase = GetCastUseCase(detailMovieRepository = detailMovieRepository),
            getMovieDetailUseCase = GetMovieDetailUseCase(
                detailMovieRepository = detailMovieRepository
            ),
            saveMovieToWatchlistUseCase = SaveMovieToWatchlistUseCase(
                firebaseRepository = firebaseRepository
            )
        )
    }


}