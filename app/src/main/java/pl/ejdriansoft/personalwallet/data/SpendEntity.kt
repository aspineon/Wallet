package pl.ejdriansoft.personalwallet.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "spends")
data class SpendEntity(
    val comment: String,
    val category: Int,
    val date: Date
) {
    @PrimaryKey(autoGenerate = true)
    lateinit var id: UUID
}