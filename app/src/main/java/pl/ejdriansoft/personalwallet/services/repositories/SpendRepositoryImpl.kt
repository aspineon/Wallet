package pl.ejdriansoft.personalwallet.services.repositories

import pl.ejdriansoft.personalwallet.data.SpendEntity
import pl.ejdriansoft.personalwallet.db.SpendDao
import pl.ejdriansoft.personalwallet.db.TagMapDao

class SpendRepositoryImpl (val spendDao: SpendDao, val tagMapDao: TagMapDao): SpendRepository {

    override fun getAllByTagName(name: String): List<SpendEntity> {
        return spendDao.getAllByTagName(name)
    }

    override fun getAll(): List<SpendEntity> {
        return spendDao.getAll()
    }

    override fun getById(id: String): SpendEntity {
        return spendDao.getById(id)
    }

    override fun create(spend: SpendEntity) {
        return spendDao.insert(spend)
    }

    override fun create(spend: List<SpendEntity>) {
        return spendDao.insert(spend)
    }

    override fun update(spend: SpendEntity) {
        return spendDao.update(spend)
    }

    override fun delete(spend: SpendEntity) {
        spendDao.delete(spend)
    }
}