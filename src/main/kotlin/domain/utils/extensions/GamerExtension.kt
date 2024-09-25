package br.com.gabriel.domain.utils.extensions

import br.com.gabriel.domain.entities.GamerEntity
import br.com.gabriel.domain.models.Gamer


fun Gamer.toEntity() : GamerEntity {
    return GamerEntity(this.nome,this.email,this.dataNascimento, this.apelidoUsuario)
}

fun GamerEntity.toModel() : Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}