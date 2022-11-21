package ni.edu.uca.blooming.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User:: class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDatabase(context: Context): UserDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(   this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase:: class.java,
                    "db_user"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

