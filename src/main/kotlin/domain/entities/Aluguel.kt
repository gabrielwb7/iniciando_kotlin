package br.com.gabriel.domain.entities

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
){
    private val precoDoAluguel = this.jogo.preco * this.periodo.emDias

    override fun toString(): String {
        return "Aluguel: " +
                "\n \tgamer=${gamer.apelidoUsuario}, " +
                "\n \tjogo=${jogo.titulo}, " +
                "\n \tperiodo=${periodo.emDias}, " +
                "\n \tprecoDoAluguel=$precoDoAluguel"
    }


}
