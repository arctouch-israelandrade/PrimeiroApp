package com.arctouch.primeiroapp

import javax.inject.Inject

class FilmesRepository @Inject constructor() {

    val apiService = BuilderRetrofit().retrofit.create(ApiService::class.java)

    suspend fun buscarFilmes(): List<Filme> {

        val result = apiService.buscarFilmes(CHAVE_API)

        if (result.isSuccessful) {

            val filmes = result.body() ?: return listOf()

            return filmes.documentos.map {
                Filme(it.filme.titulo, it.filme.descricao, it.filme.elenco)
            }

        } else {
            return listOf()
        }
    }
}           