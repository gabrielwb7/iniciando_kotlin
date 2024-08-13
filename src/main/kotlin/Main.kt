package br.com.gabriel

import br.com.gabriel.domain.entities.Periodo
import br.com.gabriel.domain.usecases.CadastroComJsonUsecase
import br.com.gabriel.domain.usecases.CadastroDinamicoUsecase
import java.time.LocalDate


fun main() {

    val cadastroDinamico = CadastroDinamicoUsecase()
    val consultaJson = CadastroComJsonUsecase()

    val listaInfoGamerJson = consultaJson.consultarJson()
    val listaGamer = consultaJson.mapearParaGamer(listaInfoGamerJson)
    val listaJogosJson = consultaJson.consultarJogosJson()

    val jogadorUm = listaGamer[3]
    val jogoUm = listaJogosJson[7]
    val jogoDois = listaJogosJson[3]
    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(15))
    val periodoDois = Periodo(LocalDate.now().plusDays(11), LocalDate.now().plusDays(15))
    val periodoTres = Periodo(LocalDate.now().plusDays(12), LocalDate.now().plusDays(15))

    jogadorUm.cadastrarPlano("BRONZE")

    jogadorUm.alugaJogo(jogoUm, periodo)
    jogadorUm.alugaJogo(jogoDois, periodoDois)
    jogadorUm.alugaJogo(jogoUm, periodoTres)

    val marco = jogadorUm.filtraPorMes(5, 2024)

    println(jogadorUm)
    println(marco)

}