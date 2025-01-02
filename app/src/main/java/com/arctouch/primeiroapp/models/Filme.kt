package com.arctouch.primeiroapp.models

import java.io.Serializable

data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: String,
) : Serializable
