package com.arctouch.primeiroapp

import com.arctouch.primeiroapp.models.PerfilData
import com.arctouch.primeiroapp.repository.PerfilRepository
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verifySequence
import org.junit.Assert.assertEquals
import org.junit.Test

class PerfilViewModelTest {
    val repositorio = mockk<PerfilRepository>()
    val perfilViewModel: PerfilViewModel = PerfilViewModel(repositorio)

    @Test
    fun test_buscarDados() {
        val perfildataesperado = PerfilData("-", "-")
        every { repositorio.buscarDados() } returns perfildataesperado
        val resultado = perfilViewModel.buscarDados()
        assertEquals(perfildataesperado, resultado)
        verifySequence { repositorio.buscarDados() }
        confirmVerified(repositorio)
    }

    @Test
    fun test_gravarDados() {
        val perfilData: PerfilData = PerfilData("17", "israel")
        every { repositorio.gravarDados(perfilData) } just runs
        perfilViewModel.gravarDados(perfilData)
        verifySequence { repositorio.gravarDados(perfilData) }
        confirmVerified(repositorio)
    }

}