package com.arctouch.primeiroapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmesViewModel @Inject constructor(

    private val filmes: FilmesRepository,
) : ViewModel() {


    private val _uiState = MutableStateFlow<FilmesUiState>(FilmesUiState.Carregando)
    val uiState = _uiState.asStateFlow()

    fun buscarFilmes() {
        viewModelScope.launch {
            val listaDeFilme = filmes.buscarFilmes()
            _uiState.value = FilmesUiState.Carregado(listaDeFilme)
        }
    }
}