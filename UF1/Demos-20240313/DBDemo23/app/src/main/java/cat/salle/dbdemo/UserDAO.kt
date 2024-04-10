package cat.salle.dbdemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user")
    fun loadAllUsers(): List<User>
}