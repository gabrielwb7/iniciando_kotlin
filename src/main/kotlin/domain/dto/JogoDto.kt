package br.com.gabriel.domain.dto

import com.google.gson.annotations.SerializedName

class JogoDto(
    @SerializedName("info")
    var infoDoJogo: InfoDoJogo
) {
    val descricao = ""

    override fun toString(): String {
        return "JogoDto(" +
                "titulo='${infoDoJogo.titulo}', " +
                "capa='${infoDoJogo.capa}', " +
                "descricao='$descricao')"
    }

}