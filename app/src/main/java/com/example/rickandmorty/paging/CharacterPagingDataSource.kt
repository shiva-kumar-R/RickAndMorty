package com.example.rickandmorty.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.service.APIService

class CharacterPagingDataSource(private val apiService: APIService) :
    PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNum = params.key ?: 1
        return try {
            val response = apiService.getCharacters(pageNum)
            val characterResponse = response.body()
            val data = characterResponse?.results

            var nextPageNumber: Int? = null
            if (characterResponse?.info?.next != null) {
                val uri = Uri.parse(characterResponse.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>) = 1
}