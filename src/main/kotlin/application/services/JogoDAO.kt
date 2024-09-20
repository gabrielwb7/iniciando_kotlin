package br.com.gabriel.application.services

import br.com.gabriel.domain.models.Jogo
import br.com.gabriel.domain.entities.JogoEntity
import javax.persistence.EntityManager

class JogoDAO(private val manager : EntityManager) {

    fun consultarJogos() : List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)

        return query.resultList.map { jogoEntity ->
            Jogo(jogoEntity.titulo, jogoEntity.capa, jogoEntity.preco, jogoEntity.descricao, jogoEntity.id)
        }
    }

    fun inserirJogo(jogo: Jogo) {
        val entityJogo = JogoEntity(jogo.titulo, jogo.capa, jogo.preco, jogo.descricao)
        manager.transaction.begin()
        manager.persist(entityJogo)
        manager.transaction.commit()
    }
}
