package com.example.mangashelfv2.ROOM

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface MangaDAO {
    @Insert(onConflict = REPLACE)
    fun insert(manga: Manga)

    @Query("SELECT * FROM manga")
    fun loadAllMangas(): List<Manga>
}