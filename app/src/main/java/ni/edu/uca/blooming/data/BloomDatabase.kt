package ni.edu.uca.blooming.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Bloom:: class], version = 1, exportSchema = false)
abstract class BloomDatabase: RoomDatabase() {
    abstract fun bloomDao(): BloomDao

    companion object{
        @Volatile
        private var INSTANCE: BloomDatabase? = null

        fun getDatabase(context: Context): BloomDatabase{
            val tempInstance = BloomDatabase.INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(   this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BloomDatabase:: class.java,
                    "db_user"
                ).build()
                BloomDatabase.INSTANCE = instance
                return instance
            }

        }
    }
}
