package com.arctouch.primeiroapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.arctouch.primeiroapp.models.PerfilData

const val PRIMEIRO_APP_SHARED_PREFERNCES = "PrimeiroAppSharedPreferences"
const val SHARED_PREFS_NOME = "nome"
const val SHARED_PREFS_IDADE = "idade"


@Composable
fun PerfilScreen(
    navController: NavHostController,
    context: Context,
    perfilViewModel: PerfilViewModel,
) {
    val perfilDados = perfilViewModel.buscarDados()
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
            text = "Idade: $idadeSalva",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {

                TextField(value = nomesalva, onValueChange = { nomesalva = it }, label = {
                    Text("Nome: ")
                })

                TextField(
                    value = idadeSalva,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() }) {
                            idadeSalva = it
                        }
                    },
                    label = { Text("Idade: ") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )


            }
        }

        Button(
            onClick = {
                if (nomesalva.isBlank() || idadeSalva.isBlank()) {
                    Toast.makeText(
                        context,
                        "Não é possível salvar com campos vazios.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val perfilDadosParaGravacao = PerfilData(
                        idadeSalva,
                        nomesalva
                    )
                    perfilViewModel.gravarDados(perfilDadosParaGravacao)

                    Toast.makeText(
                        context,
                        "Dados salvos com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .width(265.dp)
                .height(56.dp)
                .padding(vertical = 8.dp)
        ) {
            Text("Salvar")
        }

    }

}