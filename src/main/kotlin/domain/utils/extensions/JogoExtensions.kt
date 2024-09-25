package br.com.gabriel.domain.utils.extensions

import br.com.gabriel.domain.entities.JogoEntity
import br.com.gabriel.domain.models.Jogo

fun Jogo.toEntity() : JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao)
}

fun JogoEntity.toModel() : Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}