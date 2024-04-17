package com.arctouch.primeiroapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NewScreen(navController: NavController) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = "1",
                onValueChange = {},
                label = { Text("Valor Inicial") })

            Button(onClick = {}) {
                Text(text = "Incrementar")
            }

        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "X",
            fontSize = 32.sp,
        )
    }
}