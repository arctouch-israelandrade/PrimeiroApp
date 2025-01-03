package com.arctouch.primeiroapp

import androidx.lifecycle.ViewModel
import com.arctouch.primeiroapp.models.PerfilData
import com.arctouch.primeiroapp.repository.PerfilRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PerfilViewModel @Inject constructor(private val repositorio: PerfilRepository) : ViewModel() {
    fun buscarDados(): PerfilData {
        return repositorio.buscarDados()
    }

    fun gravarDados(perfilData: PerfilData) {
        repositorio.gravarDados(perfilData)
    }

}