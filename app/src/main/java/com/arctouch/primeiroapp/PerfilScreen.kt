package com.arctouch.primeiroapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PerfilScreen(navController: NavHostController) {

    var text: String by remember { mutableStateOf("") }
    var idadeSalva: String by remember { mutableStateOf("17") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "Imagem de perfil",
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = "Israel", fontSize = 24.sp
        )
        Text(
            text = "Idade: $idadeSalva", fontSize = 20.sp

        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            TextField(value = text, onValueChange = { text = it }, label = {
                Text("Idade:")
            })

            Button(onClick = { idadeSalva = text }) {
                Text("Salvar")
            }

        }

        Button(onClick = { navController.navigate("home") }

        ) {
            Text("Lista de Filmes")


        }

    }

}


