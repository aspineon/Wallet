package pl.ejdriansoft.personalwallet.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pl.ejdriansoft.personalwallet.data.TagEntity

@Dao
interface TagDao {

    @Insert
    fun insert(tag: TagEntity)

    @Insert
    fun insert(tag: List<TagEntity>)

    @Query("SELECT * FROM tags")
    fun getAll(): List<TagEntity>

    @Delete
    fun delete(tag: TagEntity)

}