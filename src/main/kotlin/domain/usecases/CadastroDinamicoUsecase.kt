package br.com.gabriel.domain.usecases

import br.com.gabriel.application.services.CapturarRespostas
import br.com.gabriel.application.services.ConsultaDadosExterno
import br.com.gabriel.domain.models.Gamer
import br.com.gabriel.domain.models.Jogo
import java.util.*

class CadastroDinamicoUsecase {

    fun cadastroDinamico() {
        println("Bem vindo a alugames! Faça seu cadastro: \n")

        val scanner = Scanner(System.`in`)
        val gamer = Gamer.criarCadastroGamer(scanner)

        println(gamer)

        do {
            val consultaDadosExterno = ConsultaDadosExterno()
            val capturarRespostas = CapturarRespostas()
            val idDeBusca = capturarRespostas.capturarId(scanner)

            var jogo: Jogo? = null

            val criarJogo = runCatching {
                val resultadoDaConsulta = consultaDadosExterno.consultarJogo(idDeBusca)
                jogo = Jogo(capa = resultadoDaConsulta.info.thumb, titulo = resultadoDaConsulta.info.title)
            }

            criarJogo.onFailure {
                println("Nao foi possível realizar a busca do id: $idDeBusca")
            }

            criarJogo.onSuccess {
                val tag = capturarRespostas.capturarDescricao(scanner)
                jogo?.descricao = tag

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
}