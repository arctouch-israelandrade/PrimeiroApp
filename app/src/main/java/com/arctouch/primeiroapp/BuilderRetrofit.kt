package com.arctouch.primeiroapp

import com.arctouch.primeiroapp.models.StringAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class BuilderRetrofit {

    private val moshi = Moshi.Builder()
        .add(StringAdapter())
        .build()

     val retrofit = Retrofit.Builder()
        .baseUrl("https://firestore.googleapis.com/v1/projects/api-filmes-9c2ce/databases/(default)/documents/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiService = retrofit.create(ApiService::class.java)



}