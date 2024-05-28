package br.com.gabriel

import br.com.gabriel.domain.usecases.CadastroComJsonUsecase
import br.com.gabriel.domain.usecases.CadastroDinamicoUsecase


fun main() {

    val cadastroDinamico = CadastroDinamicoUsecase()
    val consultaJson = CadastroComJsonUsecase()

    val listaInfoGamerJson = consultaJson.consultarJson()
    val listaGamer = consultaJson.mapearParaGamer(listaInfoGamerJson)
    val listaJogosJson = consultaJson.consultarJogosJson()

    println(listaInfoGamerJson)
    println(listaGamer)
    println(listaJogosJson)

}