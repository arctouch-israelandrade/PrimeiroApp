package com.arctouch.primeiroapp

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.arctouch.primeiroapp.ui.theme.PerfilDados

class PerfilViewModel() : ViewModel() {

    fun buscarDados(context: Context): PerfilDados {
        val sharedPref = sharedPreferences(context)
        val idadeSharedPreferences = sharedPref.getString(SHARED_PREFS_IDADE, "-") ?: ""
        val nomeSharedPreferences = sharedPref.getString(SHARED_PREFS_NOME, "-") ?: ""
        return PerfilDados(idadeSharedPreferences, nomeSharedPreferences)
    }

    fun gravarDados(context: Context, perfilDados: PerfilDados) {
        val sharedPref = sharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putString(SHARED_PREFS_NOME, perfilDados.nome)
        editor.putString(SHARED_PREFS_IDADE, perfilDados.idade)
        editor.apply()

    }

    private fun sharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            PRIMEIRO_APP_SHARED_PREFERNCES, Context.MODE_PRIVATE
        )
    }

}