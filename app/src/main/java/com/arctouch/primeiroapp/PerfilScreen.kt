package com.arctouch.primeiroapp

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

const val PRIMEIRO_APP_SHARED_PREFERNCES = "PrimeiroAppSharedPreferences"
const val SHARED_PREFS_NOME = "nome"
const val SHARED_PREFS_IDADE = "idade"


@Composable
fun PerfilScreen(
    navController: NavHostController,
    context: Context,
    perfilViewModel: PerfilViewModel
) {
    val perfilDados = perfilViewModel.buscarDados(context)
    var idadeSalva: String by rememberSaveable { mutableStateOf(perfilDados.idade) }
    var nomesalva: String by rememberSaveable { mutableStateOf(perfilDados.nome) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = "https://cdn-icons-png.flaticon.com/512/4792/4792929.png",
            contentDescription = "Imagem de perfil",
            modifier = Modifier.size(150.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nome: $nomesalva", fontSize = 24.sp
        )

        Text(
            text = "Idade: $idadeSalva", fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {

                TextField(value = nomesalva, onValueChange = { nomesalva = it }, label = {
                    Text("Nome:")
                })


                TextField(value = idadeSalva, onValueChange = { idadeSalva = it }, label = {
                    Text("Idade:")

                })


            }
        }

        Button(onClick = {
            val perfilDadosParaGravacao = PerfilViewModel.PerfilDados(
                idadeSalva,
                nomesalva
            )
            perfilViewModel.gravarDados(context, perfilDadosParaGravacao)

        }) {
            Text("Salvar")

        }

        Button(onClick = { navController.navigate(HOME) }) {


            Text("Lista de Filmes")

        }
    }

}


