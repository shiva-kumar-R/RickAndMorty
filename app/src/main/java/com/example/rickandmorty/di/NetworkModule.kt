package com.example.rickandmorty.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.rickandmorty.BuildConfig
import com.example.rickandmorty.service.APIService
import com.google.gson.GsonBuilder
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().create()

    @Provides
    @Singleton
    fun gsonConvertorFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        baseUrl: String
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit) = retrofit.create(APIService::class.java)
}