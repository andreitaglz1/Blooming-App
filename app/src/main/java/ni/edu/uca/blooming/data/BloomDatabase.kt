package ni.edu.uca.blooming.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Bloom:: class], version = 1, exportSchema = false)
abstract class BloomDatabase: RoomDatabase() {

    abstract fun getBloomDao(): BloomDao

    companion object{
        @Volatile
        private var INSTANCE: BloomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= INSTANCE ?: synchronized(LOCK){
           INSTANCE ?: buildDatabse(context).also{
               INSTANCE = it
           }
        }

        private  fun buildDatabse(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BloomDatabase::class.java,
            "bloom_database"
        ).build()

        /*
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
       */
    }
}
