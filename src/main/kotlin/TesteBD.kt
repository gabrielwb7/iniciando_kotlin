package br.com.gabriel

import br.com.gabriel.application.services.JogoDataBase
import br.com.gabriel.domain.entities.Jogo

fun main() {
    val jogoDB = JogoDataBase()

    val jogo = Jogo("teste", "teste", 2.0, "teste", 0)

    jogoDB.inserirJogo(jogo)

    val listaJogos = jogoDB.consultarJogos()
    println(listaJogos)
}