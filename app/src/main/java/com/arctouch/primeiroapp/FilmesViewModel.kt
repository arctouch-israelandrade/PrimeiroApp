package com.arctouch.primeiroapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arctouch.primeiroapp.repository.FilmesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmesViewModel @Inject constructor(
    private val filmes: FilmesRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow<FilmesUiState>(FilmesUiState.Carregando)
    val uiState = _uiState.asStateFlow()

    private val _connectionState = MutableLiveData<String>()
    val connectionState: LiveData<String> = _connectionState

    fun buscarFilmes() {
        viewModelScope.launch {
            if (internetVerif(context)) {
                val listaDeFilme = filmes.buscarFilmes()
                _uiState.value = FilmesUiState.Carregado(listaDeFilme)
                _connectionState.value = "Conexão disponível: Filmes carregados com sucesso."
                Log.d("Conexão", "Internet disponível")
            } else {
                _uiState.value = FilmesUiState.Carregando
                _connectionState.value = "Sem conexão com a internet. Verifique sua conexão."
                Log.e("Conexão", "Sem conexão com a internet")
            }
        }
    }

    private fun internetVerif (context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
