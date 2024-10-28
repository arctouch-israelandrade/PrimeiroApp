package com.arctouch.primeiroapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.arctouch.primeiroapp.repository.UiState
import androidx.lifecycle.viewmodel.compose.viewModel as viewModel


@Composable
fun DetailsScreen(filme: Filme?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column {
            if (filme != null) {

                Text(
                    text = filme.titulo,
                    fontSize = 30.sp,
                    color = Color.Black

                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = filme.descricao,
                    fontSize = 20.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                adicionaBullet(filme)

            }

        }
    }

}

@Composable
private fun adicionaBullet(filme: Filme) {
    val bullet = "\u2022"
    val messages = filme.elenco
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        text = buildAnnotatedString {
            messages.forEach {
                withStyle(style = paragraphStyle) {
                    append(bullet)
                    append("\t\t")
                    append(it)
                }
            }
        },
        color = Color.Black,
        fontSize = 20.sp
    )
}
