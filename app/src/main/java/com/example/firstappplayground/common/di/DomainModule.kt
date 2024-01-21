package com.example.firstappplayground.common.di

import com.example.firstappplayground.domain.repository.ProfileRepository
import com.example.firstappplayground.domain.usecase.GetProfileUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideGetProfileUseSase(repository: ProfileRepository): GetProfileUseCase = GetProfileUseCase(repository)
}