package pl.ejdriansoft.personalwallet.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "spends")
data class SpendEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val comment: String?,
    val price: Double,
    val date: String = Date().toString()
)