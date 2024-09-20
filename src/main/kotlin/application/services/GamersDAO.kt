package br.com.gabriel.application.services

import br.com.gabriel.domain.entities.GamerEntity
import br.com.gabriel.domain.models.Gamer
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): Dao<GamerEntity, Gamer>(manager, GamerEntity::class.java) {

    override fun toEntity(obj: Gamer): GamerEntity {
        return GamerEntity(obj.nome,obj.email,obj.dataNascimento, obj.apelidoUsuario)

    }

    override fun toModel(obj: GamerEntity): Gamer {
        return Gamer(obj.nome, obj.email, obj.dataNascimento, obj.usuario, obj.id)
    }

}