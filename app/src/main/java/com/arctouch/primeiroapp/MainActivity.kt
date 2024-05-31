package com.arctouch.primeiroapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arctouch.primeiroapp.ui.theme.PrimeiroAppTheme

const val PERFIL = "perfil"
const val HOME = "home"
const val DETALHES = "detalhes"
const val FILMES = "filme"


class MainActivity : ComponentActivity() {
    val viewModel: PerfilViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeiroAppTheme {

                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val rotaAtual = backStackEntry?.destination?.route
                Scaffold(topBar = {

                    if (rotaAtual != PERFIL) {
                        TopAppBar(title = { Text("Movies APP") }, actions = {
                            IconButton(onClick = { navController.navigate(PERFIL) }) {
                                Icon(Icons.Default.Person, contentDescription = "Tela de perfil")
                            }
                        })
                    }

                    if (rotaAtual != HOME) {
                        TopAppBar(title = { Text("Movies APP") }, navigationIcon = {
                            IconButton(onClick = { navController.navigate(HOME) }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                            }
                        })
                    }


                }) {

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        NavHost(navController = navController, startDestination = HOME) {
                            composable(HOME) {
                                Homescreen(navController = navController)
                            }
                            composable(
                                route = DETALHES,
                            ) {
                                val filme =
                                    navController.previousBackStackEntry?.savedStateHandle?.get<Filme>(
                                        FILMES
                                    )
                                DetailsScreen(filme)
                            }

                            composable(
                                route = PERFIL,
                            ) {
                                PerfilScreen(
                                    navController = navController,
                                    context = this@MainActivity,
                                    viewModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}



