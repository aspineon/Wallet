package pl.ejdriansoft.personalwallet.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.ejdriansoft.personalwallet.data.SpendEntity
import rx.Single

@Dao
interface SpendDao {

    @Insert
    fun insert(entity: SpendEntity)

    @Query("SELECT * FROM spends")
    fun getAll(): Single<List<SpendEntity>>
}