package br.com.gabriel.domain.entities

import br.com.gabriel.domain.interfaces.Recomendavel
import br.com.gabriel.domain.utils.extensions.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose

data class Jogo (@Expose val titulo: String, @Expose val capa: String) : Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    var id = 0
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String, id: Int):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "id=$id, " +
                "Preço: ${preco.formatoComDuasCasasDecimais()} \n" +
                "Reputação: ${media.formatoComDuasCasasDecimais()}"
    }

}