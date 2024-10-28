package com.arctouch.primeiroapp.repository

import com.arctouch.primeiroapp.Filme

sealed interface UiState {

    sealed class FilmesUiState : UiState {
        data class Carregado(val filmes: List<Filme>) : FilmesUiState()
        data object Carregando : FilmesUiState()
        data class Erro(val mensgem: String) : FilmesUiState()
    }
}