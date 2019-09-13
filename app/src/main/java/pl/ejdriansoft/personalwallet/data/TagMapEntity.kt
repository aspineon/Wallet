package pl.ejdriansoft.personalwallet.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "spend_tag")
data class SpendTagEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString(),
    val spendId: String,
    val tagId: String
)