package com.arctouch.primeiroapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NewScreen(navController: NavController) {

    var incrementoX by rememberSaveable { mutableStateOf("") }
    var total by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextField(
            value = incrementoX,
            onValueChange = { incrementoX = it },
            label = { Text("Digite um número") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    val number = incrementoX.toIntOrNull()
                    if (number != null) {
                        total += number
                    }
                }
            ) {
                Text("Incrementar $incrementoX")
            }

            Button(onClick = {total = 0}) {
                Text("Reset")

            }


        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total: $total",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}