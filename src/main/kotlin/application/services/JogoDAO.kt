package br.com.gabriel.application.services

import br.com.gabriel.domain.models.Jogo
import br.com.gabriel.domain.entities.JogoEntity
import br.com.gabriel.domain.utils.extensions.toEntity
import br.com.gabriel.domain.utils.extensions.toModel
import javax.persistence.EntityManager

class JogoDAO(manager : EntityManager): Dao<JogoEntity, Jogo>(manager, JogoEntity::class.java){

    override fun toEntity(obj: Jogo): JogoEntity {
        return obj.toEntity()
    }

    override fun toModel(obj: JogoEntity): Jogo {
        return obj.toModel()
    }
}
