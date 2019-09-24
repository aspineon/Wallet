package pl.ejdriansoft.personalwallet.db

import androidx.room.*
import pl.ejdriansoft.personalwallet.data.TagEntity

@Dao
interface TagDao {


    @Query("SELECT * FROM tags")
    fun getAll(): List<TagEntity>

    @Query("SELECT * FROM tags WHERE id = :id")
    fun getById(id: String): TagEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tag: TagEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tag: List<TagEntity>)

    @Delete
    fun delete(tag: TagEntity)

    @Update
    fun update(tag: TagEntity)

}