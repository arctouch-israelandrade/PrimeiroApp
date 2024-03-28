package com.arctouch.primeiroapp.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, filme: String?) {

    Column {

        if (filme != null) {
            Text(
                text = filme,
                fontSize = 24.sp

            )
        }
    }
}
