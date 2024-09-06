package com.arctouch.primeiroapp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmesViewModel @Inject constructor ( val filmes: FilmesRepository) : ViewModel() {

    fun buscarFilmes(): List<Filme> {
        return filmes.buscarFilmes()
    }

}