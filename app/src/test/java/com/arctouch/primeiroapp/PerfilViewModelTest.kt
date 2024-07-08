package com.arctouch.primeiroapp
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PerfilViewModelTest{
    val perfilViewModel: PerfilViewModel = PerfilViewModel()
    @Test
    fun test_buscarDados(){
        val resultado = perfilViewModel.buscarDados(ApplicationProvider.getApplicationContext())
        assertEquals(PerfilDados("-", "-"), resultado)
    }

    @Test
    fun test_gravarDados(){
        val perfilDados: PerfilDados = PerfilDados("17", "israel")
        perfilViewModel.gravarDados(ApplicationProvider.getApplicationContext(), perfilDados)
        val resultado =perfilViewModel.buscarDados(ApplicationProvider.getApplicationContext())
        assertEquals(perfilDados, resultado)
    }

}