package br.com.gabriel.application.services

import br.com.gabriel.domain.entities.GamerEntity
import br.com.gabriel.domain.models.Gamer
import br.com.gabriel.domain.utils.extensions.toEntity
import br.com.gabriel.domain.utils.extensions.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): Dao<GamerEntity, Gamer>(manager, GamerEntity::class.java) {

    override fun toEntity(obj: Gamer): GamerEntity {
        return obj.toEntity()

    }

    override fun toModel(obj: GamerEntity): Gamer {
        return obj.toModel()
    }

}