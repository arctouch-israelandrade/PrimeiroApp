package com.arctouch.primeiroapp
import com.arctouch.primeiroapp.models.RespostaApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService {
    @GET(value = "filmes")
    suspend fun buscarFilmes(@Query("key") apiKey: String): Response<RespostaApi>
}