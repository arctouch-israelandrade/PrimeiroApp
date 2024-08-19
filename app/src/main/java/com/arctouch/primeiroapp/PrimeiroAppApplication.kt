package com.arctouch.primeiroapp

import android.app.Application
import android.util.Log
import com.arctouch.primeiroapp.models.RespostaApi
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@HiltAndroidApp
class PrimeiroAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val apiService = BuilderRetrofit().retrofit.create(ApiService::class.java)
        val result = apiService.buscarFilmes("AIzaSyCt20TqhenbhGMoRtL1levbShsLCN44kX4")
//        if (result.isSuccessful) {
//            val filmes = result.body()
//            Log.d("israel", filmes.toString())
//        } else {
//            Log.d("israel", result.message())
//        }
        result.enqueue(object : Callback<RespostaApi>{
            override fun onFailure(p0: Call<RespostaApi>, p1: Throwable) {
                Log.d("israel", p1.localizedMessage)
            }

            override fun onResponse(p0: Call<RespostaApi>, p1: Response<RespostaApi> ) {
                if (p1.isSuccessful) {
                    val filmes = p1.body()
                    Log.d("israel", filmes.toString())

                }
            }
        })
    }



}