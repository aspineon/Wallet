package pl.ejdriansoft.personalwallet.db

import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.RoomDatabase
import pl.ejdriansoft.personalwallet.data.SpendEntity


@Database(entities = [SpendEntity::class], version = 1)
abstract class SpendDatabase : RoomDatabase() {

    abstract fun spendDao(): SpendDao
}


interface SpendRepository {

}

class SpendRepositoryImpl(private val weatherDAO: SpendDao ) : SpendRepository {}