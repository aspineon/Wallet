package pl.ejdriansoft.personalwallet.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import pl.ejdriansoft.personalwallet.data.TagMapEntity

@Dao
interface TagMapDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAssignedTag( tagMap: TagMapEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAssignedTag( tagMap: List<TagMapEntity>)
}
