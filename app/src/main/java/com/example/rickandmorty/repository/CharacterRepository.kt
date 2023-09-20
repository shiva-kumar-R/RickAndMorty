package com.example.rickandmorty.repository

import com.example.rickandmorty.model.CharactersResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CharacterRepository {
    fun getCharacters(): Flow<Response<CharactersResponse>>
}