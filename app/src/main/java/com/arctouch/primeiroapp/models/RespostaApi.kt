package com.arctouch.primeiroapp.models

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson

@JsonClass(generateAdapter = true)
data class RespostaApi(
    @Json(name = "documents") val documentos: List<Documento>
)

@JsonClass(generateAdapter = true)
data class Documento(
    @Json(name = "fields") val filme: Filme,
)

@JsonClass(generateAdapter = true)
data class Filme(
    @FirestoreField
    val titulo: String,
    @FirestoreField
    val descricao: String,
    @FirestoreField
    val elenco: String,
)

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class FirestoreField

class StringAdapter {
    @FromJson
    @FirestoreField
    fun fromJson(json: Map<String, Any?>): String {
        return json.getValue("stringValue") as String
    }

    @ToJson
    fun toJson(@FirestoreField value: String) = value
}