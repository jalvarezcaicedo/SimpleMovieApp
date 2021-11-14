package com.tech.simplemovieapp.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.tech.simplemovieapp.data.local.AppDataBase
import com.tech.simplemovieapp.data.local.FilmDao
import com.tech.simplemovieapp.data.remote.CatalogueRemoteDataSource
import com.tech.simplemovieapp.data.remote.CatalogueService
import com.tech.simplemovieapp.data.repository.FilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    @Named("base_url")
    fun providesBaseUrl(): String {
        return "https://run.mocky.io/v3/"
    }

    @Singleton
    @Provides
    fun provideHttpLoggerInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideCallFactory(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): Call.Factory {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Singleton
    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesRetrofit(
        httpLoggingInterceptor: Call.Factory,
        moshiConverterFactory: MoshiConverterFactory,
        @Named("base_url") baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .callFactory(httpLoggingInterceptor)
        .addConverterFactory(moshiConverterFactory)
        .baseUrl(baseUrl)
        .build()


    @Provides
    fun provideCharacterService(retrofit: Retrofit): CatalogueService =
        retrofit.create(CatalogueService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(catalogueService: CatalogueService) =
        CatalogueRemoteDataSource(catalogueService)

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext appContext: Context) =
        AppDataBase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideFilmDao(db: AppDataBase) = db.filmDao()


    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: CatalogueRemoteDataSource,
        localDataSource: FilmDao
    ) = FilmRepository(remoteDataSource, localDataSource)


}