package br.com.gabriel.domain.utils.extensions

import br.com.gabriel.application.dto.InfoGamerJson
import br.com.gabriel.domain.entities.Gamer

fun InfoGamerJson.criarGamer() : Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}