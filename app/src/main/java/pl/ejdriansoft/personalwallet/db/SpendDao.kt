package pl.ejdriansoft.personalwallet.db

import androidx.room.*
import pl.ejdriansoft.personalwallet.data.SpendEntity

@Dao
interface SpendDao {

    @Query("SELECT * FROM spends")
    fun getAll(): List<SpendEntity>

    @Query("SELECT * FROM spends WHERE id = :id")
    fun getById(id: String): SpendEntity

    @Query("SELECT s.* FROM spends s, tags t, tag_map st WHERE st.tagId = t.id AND (t.name IN (:tagName)) AND s.id = st.spendId GROUP BY s.id ORDER BY s.date DESC")
    fun getAllByTagName(tagName: String): List<SpendEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: SpendEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: List<SpendEntity>)

    @Update
    fun update(entity: SpendEntity)

    @Delete
    fun delete(entity: SpendEntity)
}