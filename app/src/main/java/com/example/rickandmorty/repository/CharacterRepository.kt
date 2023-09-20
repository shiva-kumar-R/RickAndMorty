package com.example.rickandmorty.repository

import androidx.paging.PagingData
import com.example.rickandmorty.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<Character>>
}