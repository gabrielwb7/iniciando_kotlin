package br.com.gabriel.domain.usecases

import br.com.gabriel.application.dto.InfoGamerJson
import br.com.gabriel.application.services.ConsultaDadosExterno
import br.com.gabriel.domain.models.Gamer
import br.com.gabriel.domain.models.Jogo
import br.com.gabriel.domain.utils.extensions.criarGamer

class CadastroComJsonUsecase {

    private val consultaExterna = ConsultaDadosExterno()

    fun consultarJson() : List<InfoGamerJson> {
        return consultaExterna.consultarGamer()
    }

    fun consultarJogosJson() : List<Jogo> {
        return consultaExterna.consultarJogoJson()
    }

    fun mapearParaGamer(listaInfoGamer : List<InfoGamerJson>) : List<Gamer> {
        return listaInfoGamer.map {
            infoGamerJson -> infoGamerJson.criarGamer()
        }
    }
}