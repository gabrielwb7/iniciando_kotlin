package br.com.gabriel

import br.com.gabriel.application.services.JogoDataBase

fun main() {
    val jogoDB = JogoDataBase()

    val listaJogos = jogoDB.consultarJogos()

    println(listaJogos)
}