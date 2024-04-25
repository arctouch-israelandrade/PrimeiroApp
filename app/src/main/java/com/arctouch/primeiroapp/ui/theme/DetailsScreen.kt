package com.arctouch.primeiroapp.ui.theme

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arctouch.primeiroapp.Filme


@Composable
fun DetailsScreen(filme: Filme?) {

    
    Column {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            Column {


            if (filme != null) {

                Text(
                    text = filme.titulo,
                    fontSize = 30.sp,
                    color = Color.White

                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = filme.descricao,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = filme.elenco,
                    fontSize = 20.sp,
                    color = Color.White

                )
            }

            }
        }

    }
}
