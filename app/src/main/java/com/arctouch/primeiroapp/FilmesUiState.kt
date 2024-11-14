package com.arctouch.primeiroapp

sealed interface FilmesUiState {
    data object Carregando : FilmesUiState
    data class Carregado(val filmes: List<Filme>) : FilmesUiState
    data class Erro(val mensagem: String) : FilmesUiState
}