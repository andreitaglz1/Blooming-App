package ni.edu.uca.blooming.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BloomDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBloom(bloom: Bloom)

    @Query("SELECT * FROM tbl_bloom ORDER BY idBloom DESC")
    fun getAllBloom(): List<Bloom>

    @Update
    suspend fun updateBloom(bloom: Bloom)

    @Delete
    suspend fun deleteBloom(bloom: Bloom)

    /*@Query("SELECT * FROM tbl_bloom ORDER BY idBloom ASC")
    fun readAllData(): LiveData<List<Bloom>>*/
}

/*
@Query("SELECT * FROM tbl_bloom WHERE idBloom= :idBloom")
fun getById(idBloom: Int): Bloom
}*/

/*@Update
fun update(bloom: Bloom)
}*/

/*@Delete
fun update(bloom: Bloom)
}*/
