package cat.salle.dbdemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface TvShowDAO {
    @Insert(onConflict = REPLACE)
    fun insert(tvshow: TvShow)

    @Query("SELECT * FROM tvshow")
    fun loadAllShows(): List<TvShow>

    @Query("SELECT * FROM tvshow WHERE genre == :genre")
    fun loadAllAnimes(genre: String): List<TvShow>

    @Query("DELETE FROM tvshow")
    fun deleteAllShows()
}