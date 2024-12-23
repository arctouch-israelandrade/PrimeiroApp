package com.arctouch.primeiroapp.repository

import android.content.Context
import com.arctouch.primeiroapp.PRIMEIRO_APP_SHARED_PREFERNCES
import com.arctouch.primeiroapp.SHARED_PREFS_IDADE
import com.arctouch.primeiroapp.SHARED_PREFS_NOME
import com.arctouch.primeiroapp.models.PerfilData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PerfilRepository @Inject constructor(
    @ApplicationContext context: Context
) {
    private val sharedPref = context.getSharedPreferences(
        PRIMEIRO_APP_SHARED_PREFERNCES, Context.MODE_PRIVATE
    )

    fun buscarDados(): PerfilData {
        val idadeSharedPreferences = sharedPref.getString(SHARED_PREFS_IDADE, "") ?: ""
        val nomeSharedPreferences = sharedPref.getString(SHARED_PREFS_NOME, "") ?: ""
        return PerfilData(idadeSharedPreferences, nomeSharedPreferences)
    }


    fun gravarDados(perfilData: PerfilData) {
        val editor = sharedPref.edit()
        editor.putString(SHARED_PREFS_NOME, perfilData.nome)
        editor.putString(SHARED_PREFS_IDADE, perfilData.idade)
        editor.apply()

    }
}