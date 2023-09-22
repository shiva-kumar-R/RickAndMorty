package com.example.rickandmorty.di

import com.example.rickandmorty.repository.CharacterRepository
import com.example.rickandmorty.repository.CharacterRepositoryImpl
import com.example.rickandmorty.service.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(apiService: APIService): CharacterRepository = CharacterRepositoryImpl(apiService)
}