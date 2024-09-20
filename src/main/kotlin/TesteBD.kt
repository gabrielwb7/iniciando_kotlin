package br.com.gabriel

import br.com.gabriel.application.services.GamersDAO
import br.com.gabriel.application.services.JogoDAO
import br.com.gabriel.domain.models.Gamer
import br.com.gabriel.domain.models.Jogo
import br.com.gabriel.infra.config.DatabaseConfig

fun main() {
    val manager = DatabaseConfig.obterConexao()
    val jogoDB = JogoDAO(manager)
    val gamerDB = GamersDAO(manager)

    val jogo = Jogo("teste", "teste", 2.0, "teste", 0)

    jogoDB.inserirJogo(jogo)

    val listaJogos = jogoDB.consultarJogos()
    println(listaJogos)
    println("---------------------------------------------")

    val gamer = Gamer(
        "gabriel",
        "teste@teste.com",
        "26/11/1996",
        "gabs"
    )

    gamerDB.inserirGamer(gamer)
    println(gamerDB.consultarGamers())

    manager.close()
}