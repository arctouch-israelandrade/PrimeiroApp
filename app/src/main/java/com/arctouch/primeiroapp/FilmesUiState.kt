package com.arctouch.primeiroapp.repository

import com.arctouch.primeiroapp.Filme

sealed interface UiState {
    data object Carregando : UiState


    sealed class FilmesUiState : UiState {
        data class Carregado(val filmes: List<Filme>) : FilmesUiState()
        data class Erro(val mensgem: String) : FilmesUiState()
    }
}