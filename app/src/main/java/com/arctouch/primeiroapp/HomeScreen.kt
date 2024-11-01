package com.arctouch.primeiroapp

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arctouch.primeiroapp.repository.FilmesUiState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: List<String>,
) : Parcelable

@Composable
fun Homescreen(navController: NavHostController, viewModel: FilmesViewModel) {
    viewModel.buscarFilmes()
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is FilmesUiState.Carregado -> {
            val filmes = (uiState as FilmesUiState.Carregado).filmes

            LazyColumn {
                items(filmes) { filme ->
                    Text(text = filme.titulo, modifier = Modifier
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                "filme", filme
                            )
                            navController.navigate(DETALHES)
                        }
                        .padding(16.dp))
                }

            }

        }

        is FilmesUiState.Carregando -> {
            Text(text = "Carregando...", modifier = Modifier.padding(16.dp))
        }

        else -> {
            println("Erro")
        }
    }

}













