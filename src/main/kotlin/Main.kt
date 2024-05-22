package br.com.gabriel

import br.com.gabriel.application.services.ConsultaJogo
import br.com.gabriel.application.services.CapturarRespostas
import br.com.gabriel.domain.entities.Gamer
import br.com.gabriel.domain.entities.Jogo


fun main() {

    val consultaJogo = ConsultaJogo()
    val capturarRespostas = CapturarRespostas()

    val idDeBusca = capturarRespostas.capturarId()

    var jogo:Jogo? = null

    val criarJogo = runCatching {
        val resultadoDaConsulta = consultaJogo.consultarJogo(idDeBusca)
        jogo = Jogo(capa = resultadoDaConsulta.info.thumb, titulo = resultadoDaConsulta.info.title)
    }

    criarJogo.onFailure {
        println("Nao foi possível realizar a busca do id: $idDeBusca")
    }

    criarJogo.onSuccess {
        val tag = capturarRespostas.capturarDescricao()
        jogo?.tag = tag

        println(jogo)
    }

    val gamerUm = Gamer("Gabriel", "teste@teste.com", "11/12/2000", "gabs")
    println(gamerUm)
}