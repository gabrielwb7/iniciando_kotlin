package br.com.gabriel.domain.entities

import br.com.gabriel.domain.utils.extensions.formatoComDuasCasasDecimais

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
){
    private val precoDoAluguel = gamer.plano?.obterOValor(this)

    override fun toString(): String {
        return "Aluguel: " +
                "\n \tgamer=${gamer.apelidoUsuario}, " +
                "\n \tjogo=${jogo.titulo}, " +
                "\n \tperiodo=${periodo.emDias}, " +
                "\n \tprecoDoAluguel=${precoDoAluguel?.formatoComDuasCasasDecimais()}"
    }


}
