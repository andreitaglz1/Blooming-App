package ni.edu.uca.blooming

@Entity(tableName = "tbl_user")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    val password: String
)
