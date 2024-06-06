package com.arctouch.primeiroapp

import android.content.Context
import androidx.lifecycle.ViewModel

class PerfilViewModel() : ViewModel() {
    private fun sharedPreferences(context: Context) {
        val sharedPref = context.getSharedPreferences(
            PRIMEIRO_APP_SHARED_PREFERNCES, Context.MODE_PRIVATE
        )
    }

    fun buscarDados(context: Context): PerfilDados {
        val sharedPref = context.getSharedPreferences(
            PRIMEIRO_APP_SHARED_PREFERNCES, Context.MODE_PRIVATE
        )
        val idadeSharedPreferences = sharedPref.getString(SHARED_PREFS_IDADE, "-") ?: ""
        val nomeSharedPreferences = sharedPref.getString(SHARED_PREFS_NOME, "-") ?: ""
        return PerfilDados(idadeSharedPreferences, nomeSharedPreferences)
    }

    fun gravarDados(context: Context, perfilDados: PerfilDados) {
        val sharedPref = context.getSharedPreferences(
            PRIMEIRO_APP_SHARED_PREFERNCES, Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putString(SHARED_PREFS_NOME, perfilDados.nome)
        editor.putString(SHARED_PREFS_IDADE, perfilDados.idade)
        editor.apply()

    }

    data class PerfilDados(
        val idade: String,
        val nome: String,
    )
}