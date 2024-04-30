package com.example.mangashelfv2.ROOM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Manga::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun MangaDAO(): MangaDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "mangas.db").build()
                } }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}