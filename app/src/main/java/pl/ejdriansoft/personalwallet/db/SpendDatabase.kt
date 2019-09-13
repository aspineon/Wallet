package pl.ejdriansoft.personalwallet.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.ejdriansoft.personalwallet.data.SpendEntity
import pl.ejdriansoft.personalwallet.data.TagMapEntity
import pl.ejdriansoft.personalwallet.data.TagEntity


@Database(entities = [SpendEntity::class, TagEntity::class, TagMapEntity::class], version = 1)
abstract class SpendDatabase : RoomDatabase() {

    abstract fun spendDao(): SpendDao
    abstract fun tagDao(): TagDao
    abstract fun tagMapDao(): TagMapDao
}


interface SpendRepository {

}

class SpendRepositoryImpl(private val spendDao: SpendDao) : SpendRepository {}