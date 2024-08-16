package br.com.gabriel.domain.utils.extensions

import br.com.gabriel.application.dto.InfoJogoJson
import br.com.gabriel.domain.entities.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}