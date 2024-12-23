package com.arctouch.primeiroapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filme(
    val titulo: String,
    val descricao: String,
    val elenco: String,
) : Parcelable
