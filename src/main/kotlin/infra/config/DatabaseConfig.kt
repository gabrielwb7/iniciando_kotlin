package br.com.gabriel.infra.config

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object DatabaseConfig {
    fun obterConexao(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
        return factory.createEntityManager()
    }
}