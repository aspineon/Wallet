package pl.ejdriansoft.personalwallet.db

import androidx.room.*
import pl.ejdriansoft.personalwallet.data.TagEntity

@Dao
interface TagDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tag: TagEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tag: List<TagEntity>)

    @Query("SELECT * FROM tags")
    fun getAll(): List<TagEntity>

    @Delete
    fun delete(tag: TagEntity)

}