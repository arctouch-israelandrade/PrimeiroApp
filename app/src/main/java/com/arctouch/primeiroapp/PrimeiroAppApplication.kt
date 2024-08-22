package com.arctouch.primeiroapp

import android.app.Application
import android.util.Log
import com.arctouch.primeiroapp.models.RespostaApi
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@HiltAndroidApp
class PrimeiroAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val apiService = BuilderRetrofit().retrofit.create(ApiService::class.java)
        val applicationScope = MainScope()
        applicationScope.launch {
            val result = apiService.buscarFilmes("AIzaSyCt20TqhenbhGMoRtL1levbShsLCN44kX4")
            if (result.isSuccessful) {
                val filmes = result.body()
                Log.d("israel", filmes.toString())
            } else {
                Log.d("israel", result.message())
            }
        }


    }


}