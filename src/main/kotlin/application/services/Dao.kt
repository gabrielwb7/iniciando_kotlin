package br.com.gabriel.application.services

import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder.In

abstract class Dao<TEntity, TModel>(
    protected val manager: EntityManager,
    protected val entityType : Class<TEntity>
    ) {

    abstract fun toEntity(obj : TModel) : TEntity
    abstract fun toModel(obj : TEntity) : TModel

    open fun getLista() : List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)

        return query.resultList.map { entity ->
            toModel(entity)
        }
    }

    open fun inserir(obj: TModel) {
        val entity = toEntity(obj)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun consultarPorId(id : Int) : TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val result = query.singleResult
        return toModel(result)
    }

    open fun exclusaoPorId(id : Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val result = query.singleResult

        manager.transaction.begin()
        manager.remove(result)
        manager.transaction.commit()
    }
}