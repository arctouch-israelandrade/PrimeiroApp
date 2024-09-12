package com.arctouch.primeiroapp

import android.content.Context
import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: List<String>,
) : Parcelable

@Composable
fun Homescreen(
    navController: NavHostController,
    filmesViewModel: FilmesViewModel
) {

    val filmes = filmesViewModel.buscarFilmes()

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













