package br.com.gabriel.domain.usecases

import br.com.gabriel.application.dto.InfoGamerJson
import br.com.gabriel.application.services.ConsultarGamer

class CadastroComJsonUsecase {

    private val consultarGamer = ConsultarGamer()

    fun consultarJson() : List<InfoGamerJson> {
        return consultarGamer.consultarGamer()
    }
}