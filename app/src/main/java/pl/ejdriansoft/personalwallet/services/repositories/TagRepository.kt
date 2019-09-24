package pl.ejdriansoft.personalwallet.services.repositories

import pl.ejdriansoft.personalwallet.data.TagEntity

interface TagRepository {

    fun getAll(): List<TagEntity>
    fun getById(id: String): TagEntity
    fun create(tag: TagEntity)
    fun create(tags: List<TagEntity>)
    fun update(tag: TagEntity)
    fun delete(tag: TagEntity)
}
