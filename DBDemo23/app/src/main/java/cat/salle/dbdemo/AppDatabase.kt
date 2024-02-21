package cat.salle.dbdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [User::class, TvShow::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun UserDAO(): UserDAO
    abstract fun TvShowDAO(): TvShowDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app.db").build()
                } }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}