package com.arctouch.primeiroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arctouch.primeiroapp.ui.theme.DetailsScreen
import com.arctouch.primeiroapp.ui.theme.PrimeiroAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeiroAppTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val rotaAtual = backStackEntry?.destination?.route

                Scaffold(topBar = {

                    if (rotaAtual != "perfil") {
                        TopAppBar(title = { Text("Movies APP") }, navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
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

                        NavHost(navController = navController, startDestination = "perfil") {
                            composable("perfil") {
                                PerfilScreen(navController = navController)
                            }
                            composable("home") {
                                Homescreen(navController = navController)
                            }
                            composable(
                                route = "detalhes/{titulo}/{descricao}/{elenco}",
                                arguments = listOf(
                                    navArgument("titulo") { type = NavType.StringType },
                                    navArgument("descricao") { type = NavType.StringType },
                                    navArgument("elenco") { type = NavType.StringType },
                                )
                            ) {
                                val titulo = it.arguments?.getString("titulo")
                                val descricao = it.arguments?.getString("descricao")
                                val elenco = it.arguments?.getString("elenco")
                                DetailsScreen(titulo, descricao, elenco)
                            }

                        }
                    }
                }

            }
        }
    }
}



