package com.arctouch.primeiroapp

sealed interface FilmesUiState {
    data class Carregado(val filmes: List<Filme>) : FilmesUiState
    data object Carregando : FilmesUiState
    data class Erro(val mensgem: String) : FilmesUiState
}