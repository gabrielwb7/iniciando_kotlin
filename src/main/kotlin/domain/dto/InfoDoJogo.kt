package br.com.gabriel.domain.dto

import com.google.gson.annotations.SerializedName

class InfoDoJogo(
    @SerializedName("title")
    val titulo: String,

    @SerializedName("thumb")
    val capa: String
)