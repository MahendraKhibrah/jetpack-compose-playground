package com.example.firstappplayground.common.di

import com.example.firstappplayground.data.api.ProfileApi
import com.example.firstappplayground.data.repository.ProfileRepositoryImpl
import com.example.firstappplayground.domain.repository.ProfileRepository
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun bindProfileRepository(api : ProfileApi): ProfileRepository = ProfileRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideProfileApi(retrofit: Retrofit): ProfileApi = retrofit.create(ProfileApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        client: OkHttpClient,
        ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.api-ninjas.com/v1/")
            .client(client)
            .build()

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(60L, TimeUnit.SECONDS)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        builder.addInterceptor(logger)

        return builder.build()
    }
}