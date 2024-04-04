package com.arctouch.primeiroapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp


@Composable
fun DetailsScreen(titulo: String?, elenco: String?, descricao: String?) {
    Column {
        if (titulo != null && descricao != null && elenco != null) {
            Text(
                text = titulo,
                fontSize = 24.sp

            )

            Text(
                text = descricao,
                fontSize = 24.sp

            )

            Text(
                text = elenco,
                fontSize = 24.sp

            )


        }
    }
}
