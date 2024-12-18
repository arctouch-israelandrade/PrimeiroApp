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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailsScreen(filme: Filme?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
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

                AdicionaBullet(filme)

            }

        }
    }

}

@Composable
private fun AdicionaBullet(filme: Filme) {
    val bullet = "\u2022"
    val elencoString = filme.elenco
    val messages = elencoString.split("\\n")

    val filteredMessages = messages
        .map { it.trim() }
        .filter { it.isNotEmpty() }

    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        text = buildAnnotatedString {
            filteredMessages.forEachIndexed { index, message ->
                withStyle(style = paragraphStyle) {
                    if (index > 0) {
                        append(bullet)
                    }
                    append("\t\t")
                    append(message.trim())
                }
            }
        },
        color = Color.Black,
        fontSize = 20.sp
    )
}

