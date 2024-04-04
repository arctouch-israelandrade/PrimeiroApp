package com.arctouch.primeiroapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.sp
import androidx.navigation.Navigator

data class Filme(val titulo: String, val descricao: String, val elenco: String)
@Composable
fun Homescreen(navController: NavHostController) {

    val filmes = listOf(
        Filme("Poderoso Chefão", "abc", "a, b, c ,d"),
        Filme("Se Beber, Não Case!", "abc", "a, b, c ,d"),
        Filme("Mad Max: Estrada da Fúria", "abc", "a, b, c ,d"),
        Filme("Interstellar", "abc", "a, b, c ,d"),
        Filme("Toy Story", "abc", "a, b, c ,d"),
        Filme("Harry Potter e a Pedra Filosofal", "abc", "a, b, c ,d"),
        Filme("O Silêncio dos Inocentes", "abc", "a, b, c ,d"),
        Filme("Diário de uma Paixão", "abc", "a, b, c ,d"),
        Filme("La La Land: Cantando Estações", "abc", "a, b, c ,d"),
        Filme("A Marcha dos Pingüins", "abc", "a, b, c ,d"),
    )

    Column {
        for (filme in filmes)
           ClickableText(
               text = AnnotatedString (filme.titulo),
               onClick = { navController.navigate("detalhes/${filme.titulo}/${filme.descricao}/${filme.elenco}" )
               }
           )
    }


}














