package ni.edu.uca.blooming.data
import androidx.lifecycle.LiveData

class BloomRepository(private val bloomDao: BloomDao) {
    val readAllData: LiveData<List<Bloom>> = bloomDao.readAllData()

    suspend fun addBloom(bloom: Bloom){
        bloomDao.addBloom(bloom)

    }
}