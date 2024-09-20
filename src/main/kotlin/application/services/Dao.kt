package br.com.gabriel.application.services

import javax.persistence.EntityManager

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
}