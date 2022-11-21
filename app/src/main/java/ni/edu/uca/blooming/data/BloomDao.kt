package ni.edu.uca.blooming.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BloomDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBloom(bloom: Bloom)

    @Query("SELECT * FROM tbl_bloom ORDER BY idBloom ASC")
    fun readAllData(): LiveData<List<Bloom>>
}


