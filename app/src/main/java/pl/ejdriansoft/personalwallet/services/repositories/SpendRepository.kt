package pl.ejdriansoft.personalwallet.services.repositories

import pl.ejdriansoft.personalwallet.data.SpendEntity

interface SpendRepository {

    fun getAll(): List<SpendEntity>
    fun getById(id: String): SpendEntity
    fun getAllByTagName(name: String): List<SpendEntity>
    fun create(spend: SpendEntity)
    fun create(spend: List<SpendEntity>)
    fun update(spend: SpendEntity)
    fun delete(spend: SpendEntity)
}
