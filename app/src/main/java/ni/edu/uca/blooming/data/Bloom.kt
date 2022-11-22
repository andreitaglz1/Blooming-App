package ni.edu.uca.blooming.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_bloom")
data class Bloom (

    var textBloom: String =" "

    ){
    @PrimaryKey(autoGenerate = true)
    var idBloom: Int = 0
}




