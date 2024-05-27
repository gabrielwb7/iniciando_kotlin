package br.com.gabriel.domain.usecases

import br.com.gabriel.application.dto.InfoGamerJson
import br.com.gabriel.application.services.ConsultaDadosExterno
import br.com.gabriel.domain.entities.Gamer
import br.com.gabriel.domain.utils.extensions.criarGamer

class CadastroComJsonUsecase {

    private val consultarGamer = ConsultaDadosExterno()

    fun consultarJson() : List<InfoGamerJson> {
        return consultarGamer.consultarGamer()
    }

    fun mapearParaGamer(listaInfoGamer : List<InfoGamerJson>) : List<Gamer> {
        return listaInfoGamer.map {
            infoGamerJson -> infoGamerJson.criarGamer()
        }
    }
}