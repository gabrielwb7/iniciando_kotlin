package br.com.gabriel

import br.com.gabriel.domain.models.Periodo
import br.com.gabriel.domain.usecases.CadastroComJsonUsecase
import br.com.gabriel.domain.usecases.CadastroDinamicoUsecase
import br.com.gabriel.domain.usecases.CompartilharJsonUsecase
import java.time.LocalDate


fun main() {

    val cadastroDinamico = CadastroDinamicoUsecase()
    val consultaJson = CadastroComJsonUsecase()
    val compartilhar = CompartilharJsonUsecase()

    val listaInfoGamerJson = consultaJson.consultarJson()
    val listaGamer = consultaJson.mapearParaGamer(listaInfoGamerJson)
    val listaJogosJson = consultaJson.consultarJogosJson()

    val jogadorUm = listaGamer[3]
    val jogoUm = listaJogosJson[7]
    val jogoDois = listaJogosJson[3]
    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(15))
    val periodoDois = Periodo(LocalDate.now().plusDays(11), LocalDate.now().plusDays(15))
    val periodoTres = Periodo(LocalDate.now().plusDays(12), LocalDate.now().plusDays(15))

    jogadorUm.cadastrarPlano("PRATA")
    jogadorUm.recomendar(10)
    jogadorUm.recomendar(9)

    jogadorUm.alugaJogo(jogoUm, periodo)
    jogadorUm.alugaJogo(jogoDois, periodoDois)
    jogadorUm.alugaJogo(jogoUm, periodoTres)

    println(jogadorUm)

    val jogoResidentVillage = listaJogosJson.get(10)
    val jogoSpider = listaJogosJson.get(13)
    val jogoTheLastOfUs = listaJogosJson.get(2)
    val jogoDandara = listaJogosJson.get(5)
    val jogoAssassins = listaJogosJson.get(4)
    val jogoCyber = listaJogosJson.get(6)
    val jogoGod = listaJogosJson.get(7)
    val jogoSkyrim = listaJogosJson.get(18)

    jogadorUm.recomendarJogo(jogoResidentVillage, 7)
    jogadorUm.recomendarJogo(jogoTheLastOfUs, 10)
    jogadorUm.recomendarJogo(jogoAssassins, 8)
    jogadorUm.recomendarJogo(jogoCyber, 7)
    jogadorUm.recomendarJogo(jogoGod, 10)
    jogadorUm.recomendarJogo(jogoDandara, 8)
    jogadorUm.recomendarJogo(jogoSkyrim, 8)
    jogadorUm.recomendarJogo(jogoSpider, 6)

    val json = compartilhar.converterParaJson(jogadorUm.jogosRecomendados)
    val arquivoPath = jogadorUm.idUsuario?.let { compartilhar.gerarArquivoJson(json, it) }
    println(json)
    println("----------->")
    println(arquivoPath?.absolutePath)
}