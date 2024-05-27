package br.com.gabriel.application.dto

data class InfoApi(val info: InfoDoJogo) {

    override fun toString(): String {
        return info.toString()
    }
}