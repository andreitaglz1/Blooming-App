package ni.edu.uca.blooming.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_bloom")
data class Bloom (
    @PrimaryKey(autoGenerate = true)
    val idBloom: Int,
    val note: String

    )




