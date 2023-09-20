package com.example.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private lateinit var _characters: PagingData<Character>
    private val character get() = _characters

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() = viewModelScope.launch {
        characterRepository.getCharacters()
            .onEach { data ->
                _characters = data
            }
            .cachedIn(viewModelScope)
    }
}