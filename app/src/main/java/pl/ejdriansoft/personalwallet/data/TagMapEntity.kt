package pl.ejdriansoft.personalwallet.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE


@Entity(tableName = "tag_map", primaryKeys = ["spendId", "tagId" ], foreignKeys = [
    ForeignKey(
        entity = SpendEntity::class,
        parentColumns = ["id"],
        childColumns = ["spendId"],
        onDelete = CASCADE
    ),
    ForeignKey(
        entity = TagEntity::class,
        parentColumns = ["id"],
        childColumns = ["tagId"],
        onDelete = CASCADE
    )])
data class TagMapEntity(
    val spendId: String,
    val tagId: String
)
