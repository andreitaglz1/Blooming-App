package ni.edu.uca.blooming.data
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.blooming.data.Bloom
import ni.edu.uca.blooming.data.BloomDatabase
import ni.edu.uca.blooming.data.BloomRepository

class BloomViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Bloom>>
    private val repository: BloomRepository
    init{
        val bloomDao = BloomDatabase.getDatabase(application).bloomDao()
        repository = BloomRepository(bloomDao)
        readAllData = repository.readAllData
    }

    fun addBloom(bloom: Bloom){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBloom(bloom)
        }
    }
}