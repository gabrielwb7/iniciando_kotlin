package br.com.gabriel

import br.com.gabriel.application.services.ConsultaJogo
import br.com.gabriel.application.services.CapturarRespostas
import br.com.gabriel.domain.entities.Gamer
import br.com.gabriel.domain.entities.Jogo
import java.util.*


fun main() {

    println("Bem vindo a alugames! Faça seu cadastro: \n")

    val scanner = Scanner(System.`in`)
    val gamer = Gamer.criarCadastroGamer(scanner)

    println(gamer)

    do {
        val consultaJogo = ConsultaJogo()
        val capturarRespostas = CapturarRespostas()
        val idDeBusca = capturarRespostas.capturarId(scanner)

        var jogo: Jogo? = null

        val criarJogo = runCatching {
            val resultadoDaConsulta = consultaJogo.consultarJogo(idDeBusca)
            jogo = Jogo(capa = resultadoDaConsulta.info.thumb, titulo = resultadoDaConsulta.info.title)
        }

        criarJogo.onFailure {
            println("Nao foi possível realizar a busca do id: $idDeBusca")
        }

        criarJogo.onSuccess {
            val tag = capturarRespostas.capturarDescricao(scanner)
            jogo?.tag = tag

            println(jogo)

            println("Você deseja inserir esse jogo na sua lista? S/N")
            val desejaInserir = scanner.nextLine()

            if (desejaInserir.equals("S", true))
                gamer.listaDeJogos.add(jogo)
        }

        println("Você deseja continuar a busca? S/N")
        val desejaEncerrar = scanner.nextLine()
        val encerrarBusca = desejaEncerrar.equals("S", true)

    } while (encerrarBusca)

    print(gamer.listaDeJogos)
    println("\n Encerrado a busca")

}