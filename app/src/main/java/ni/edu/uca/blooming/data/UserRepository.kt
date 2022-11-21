package ni.edu.uca.blooming.data
import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(usuario: User){
        userDao.addUser(usuario)

    }
}
