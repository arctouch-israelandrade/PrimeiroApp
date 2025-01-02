package com.arctouch.primeiroapp

import com.arctouch.primeiroapp.models.Filme

sealed interface FilmesUiState {
    data object Carregando : FilmesUiState
    data class Carregado(val filmes: List<Filme>) : FilmesUiState
    data class Erro(val mensagem: String) : FilmesUiState
}