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

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    fun provideGson() = GsonBuilder().create()

    @Provides
    fun gsonConvertorFactory() = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        baseUrl: String
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    fun provideAPIService(retrofit: Retrofit) = retrofit.create(APIService::class.java)
}