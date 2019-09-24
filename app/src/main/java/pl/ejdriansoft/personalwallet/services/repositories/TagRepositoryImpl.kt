package pl.ejdriansoft.personalwallet.services.repositories

import pl.ejdriansoft.personalwallet.data.TagEntity
import pl.ejdriansoft.personalwallet.db.TagDao

class TagRepositoryImpl(val tagDao: TagDao) : TagRepository {

    override fun getAll(): List<TagEntity> {
        return tagDao.getAll()
    }

    override fun getById(id: String): TagEntity {
        return tagDao.getById(id)
    }

    override fun create(tag: TagEntity) {
        return tagDao.insert(tag)
    }

    override fun create(tags: List<TagEntity>) {
        return tagDao.insert(tags)
    }

    override fun update(tag: TagEntity) {
        return tagDao.update(tag)
    }

    override fun delete(tag: TagEntity) {
        tagDao.delete(tag)
    }
}
