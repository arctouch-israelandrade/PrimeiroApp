package com.arctouch.primeiroapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun Homesreem(navController: NavHostController) {

    val filmes = listOf(
        "1. O Poderoso Chefão",
        "2. Se Beber, Não Case!",
        "3. Mad Max: Estrada da Fúria",
        "4. Interstellar",
        "5. Toy Story",
        "6. Harry Potter e a Pedra Filosofal",
        "7. O Silêncio dos Inocentes",
        "8. Diário de uma Paixão",
        "9. La La Land: Cantando Estações",
        "10. A Marcha dos Pingüins"
    )

    Column {
        for (filme in filmes) {
            Text (text = filme)
        }
    }
}