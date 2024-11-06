package com.arctouch.primeiroapp.repository

sealed interface FilmesUiState {
    data class Carregado(val filmes: List<com.arctouch.primeiroapp.models.Filme>) : FilmesUiState
    data object Carregando : FilmesUiState
    data class Erro(val mensgem: String) : FilmesUiState
}