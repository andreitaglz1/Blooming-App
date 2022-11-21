package ni.edu.uca.blooming.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val idUser: Int,
    val username: String,
    val password: String
)
