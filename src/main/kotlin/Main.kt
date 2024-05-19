package br.com.gabriel

import br.com.gabriel.services.ConsultaJogoService


fun main() {

    val consultaJogoService = ConsultaJogoService()

    var resultadoDaConsulta = consultaJogoService.consultarJogo(146)

    println(resultadoDaConsulta)
}