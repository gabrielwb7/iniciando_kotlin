package br.com.gabriel.application.services

import br.com.gabriel.domain.entities.GamerEntity
import br.com.gabriel.domain.models.Gamer
import javax.persistence.EntityManager

class GamersDAO(private val manager: EntityManager) {

    fun inserirGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.nome,gamer.email,gamer.dataNascimento, gamer.apelidoUsuario)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }


    fun consultarGamers() : List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)

        return query.resultList.map { gamer ->
            Gamer(gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario, gamer.id)
        }
    }

}