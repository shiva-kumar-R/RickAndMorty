package com.example.rickandmorty.service

import com.example.rickandmorty.model.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int) : Response<CharactersResponse>
}