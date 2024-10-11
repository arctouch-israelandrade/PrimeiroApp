package com.arctouch.primeiroapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class PrimeiroAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val apiService = BuilderRetrofit().retrofit.create(ApiService::class.java)
        val applicationScope = MainScope()
        applicationScope.launch {
            val result = apiService.buscarFilmes(CHAVE_API)
            if (result.isSuccessful) {
                val filmes = result.body()
                Log.d("israel", filmes.toString())
            } else {
                Log.d("israel", result.message())
            }

        }


    }


}