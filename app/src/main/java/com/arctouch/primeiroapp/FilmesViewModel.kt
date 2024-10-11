package com.arctouch.primeiroapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class FilmesViewModel @Inject constructor(val filmes: FilmesRepository) : ViewModel() {
    fun buscarFilmes(): List<Filme> =
        runBlocking {
            delay(12000)
            return@runBlocking filmes.buscarFilmes()
        }
}
