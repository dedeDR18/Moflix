package com.example.core_database.entity.mapper

/**
 * Created by Dede Dari Rahmadi on 08/11/22
 */
interface EntityMapper<Domain, Entity> {

    fun asEntity(domain: Domain): Entity

    fun asDomain(entity: Entity): Domain
}