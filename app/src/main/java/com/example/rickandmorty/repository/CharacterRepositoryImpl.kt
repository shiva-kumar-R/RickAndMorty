package com.example.rickandmorty.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.paging.CharacterPagingDataSource
import com.example.rickandmorty.service.APIService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : CharacterRepository {

    override suspend fun getCharacters(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 8, prefetchDistance = 2),
        pagingSourceFactory = { CharacterPagingDataSource(apiService) }
    ).flow
}