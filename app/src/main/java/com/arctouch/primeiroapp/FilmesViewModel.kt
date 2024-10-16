package com.arctouch.primeiroapp

import androidx.lifecycle.ViewModel
import com.arctouch.primeiroapp.repository.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class FilmesViewModel @Inject constructor(val filmes: FilmesRepository) : ViewModel() {
    val uiState = MutableStateFlow<UiState.FilmesUiState>(UiState.FilmesUiState.Carregado(listOf()))

    fun buscarFilmes(): List<Filme> =
        runBlocking {
            return@runBlocking filmes.buscarFilmes()
        }
}
