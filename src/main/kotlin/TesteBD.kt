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

    jogoDB.inserir(jogo)

    val listaJogos = jogoDB.getLista()
    println(listaJogos)
    println("---------------------------------------------")

    val gamer = Gamer(
        "gabriel",
        "teste@teste.com",
        "26/11/1996",
        "gabs"
    )

    gamerDB.inserir(gamer)
    println(gamerDB.consultarPorId(1))
//    gamerDB.exclusaoPorId(2)

    println(gamerDB.getLista())
    manager.close()
}