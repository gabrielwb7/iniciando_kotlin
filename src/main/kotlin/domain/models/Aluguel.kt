package br.com.gabriel.domain.models

import br.com.gabriel.domain.models.Gamer
import br.com.gabriel.domain.models.Jogo
import br.com.gabriel.domain.models.Periodo
import br.com.gabriel.domain.utils.extensions.formatoComDuasCasasDecimais

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
){
    var id = 0
    private val precoDoAluguel = gamer.plano?.obterOValor(this)

    override fun toString(): String {
        return "Aluguel: " +
                "\n \tgamer=${gamer.apelidoUsuario}, " +
                "\n \tjogo=${jogo.titulo}, " +
                "\n \tperiodo=${periodo.emDias}, " +
                "\n \tid=$id, " +
                "\n \tprecoDoAluguel=${precoDoAluguel?.formatoComDuasCasasDecimais()}"
    }


}
