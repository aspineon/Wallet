package pl.ejdriansoft.personalwallet.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.ejdriansoft.personalwallet.data.SpendEntity

@Dao
interface SpendDao {

    @Insert
    fun insert(entity: SpendEntity)

    @Insert
    fun insert(entity: List<SpendEntity>)

    @Query("SELECT * FROM spends")
    fun getAll(): List<SpendEntity>

    @Query("SELECT s.* FROM spends s, tags t, tag_map st WHERE st.tagId = t.id AND (t.name IN (:tagName)) AND s.id = st.spendId GROUP BY s.id ORDER BY s.date DESC")
    fun getAllByTagName(tagName: String): List<SpendEntity>
}