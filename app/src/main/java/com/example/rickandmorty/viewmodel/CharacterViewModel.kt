package com.example.rickandmorty.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private var _characters = MutableStateFlow<PagingData<Character>>(PagingData.empty())
    val character: StateFlow<PagingData<Character>> = _characters

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() = viewModelScope.launch {
        characterRepository.getCharacters()
            .cachedIn(viewModelScope)
            .collect {
                _characters.emit(it)
            }
    }
}