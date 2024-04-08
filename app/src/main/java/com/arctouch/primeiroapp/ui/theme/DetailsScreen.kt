package com.arctouch.primeiroapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailsScreen(titulo: String?, descricao: String?, elenco: String? ) {
    Column {
        if (titulo != null && descricao != null && elenco != null) {
            Text(
                text = titulo,
                fontSize = 20.sp

            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = descricao,
                fontSize = 20.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = elenco,
                fontSize = 20.sp

            )
        }
    }
}
