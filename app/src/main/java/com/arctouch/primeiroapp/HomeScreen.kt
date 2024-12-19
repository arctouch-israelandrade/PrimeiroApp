package com.arctouch.primeiroapp

import android.os.Parcelable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: String,
) : Parcelable

@Composable
fun Homescreen(navController: NavHostController, viewModel: FilmesViewModel) {
    viewModel.buscarFilmes()
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is FilmesUiState.Carregado -> {
            val filmes = (uiState as FilmesUiState.Carregado).filmes

            if (filmes.size == 0) {
                EmptyState()
            } else {

                LazyColumn {
                    items(filmes) { filme ->
                        Text(
                            text = filme.titulo,
                            modifier = Modifier
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
        }

        FilmesUiState.Carregando -> {
            Carregando()
        }


        is FilmesUiState.Erro -> {
            Text(text = "Erro ao carregar filmes", modifier = Modifier.padding(16.dp))
        }


    }
}


@Composable
fun Carregando() {
    FilmesUiState.Carregando
    val shimmerColor = Color.LightGray.copy(alpha = 0.3f)
    val baseColor = Color.Gray.copy(alpha = 0.1f)

    val transition = rememberInfiniteTransition(label = "")
    val alpha by transition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "",
    )

    Column(modifier = Modifier.padding(16.dp)) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .padding(vertical = 25.dp)
                    .background(
                        color = shimmerColor.copy(alpha = alpha),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }
    }
}

@Composable
fun EmptyState() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.sem_filme),
            contentDescription = "Imagem de ERRO",
            modifier = Modifier.size(400.dp)
        )

        Text(
            text = "Não existem filmes para serem carregados no momento.",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}