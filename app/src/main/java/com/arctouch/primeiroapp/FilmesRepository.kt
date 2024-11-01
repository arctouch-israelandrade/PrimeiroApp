package com.arctouch.primeiroapp

import com.arctouch.primeiroapp.models.Filme
import javax.inject.Inject

class FilmesRepository @Inject constructor() {


     val apiService = BuilderRetrofit().retrofit.create(ApiService::class.java)

    suspend fun buscarFilmes(): List<Filme> {

        val result = apiService.buscarFilmes(CHAVE_API)

        if (result.isSuccessful) {

            val filmes = result.body() ?: return listOf()

            return filmes.documentos.map {
                it.filme
            }

        } else {
            return listOf()

        }
    }

}