package br.com.gabriel.application.services

import br.com.gabriel.domain.models.Jogo
import br.com.gabriel.domain.entities.JogoEntity
import javax.persistence.EntityManager

class JogoDAO(manager : EntityManager): Dao<JogoEntity, Jogo>(manager, JogoEntity::class.java){

    override fun toEntity(obj: Jogo): JogoEntity {
        return JogoEntity(obj.titulo, obj.capa, obj.preco, obj.descricao)
    }

    override fun toModel(obj: JogoEntity): Jogo {
        return Jogo(obj.titulo, obj.capa, obj.preco, obj.descricao, obj.id)
    }
}
