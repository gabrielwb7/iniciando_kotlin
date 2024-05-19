package br.com.gabriel.domain.dto

class InfoApi(val info: InfoDoJogo) {

    override fun toString(): String {
        return info.toString()
    }
}