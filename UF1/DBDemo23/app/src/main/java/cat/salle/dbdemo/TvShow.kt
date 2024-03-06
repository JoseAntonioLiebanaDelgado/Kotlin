package cat.salle.dbdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TvShow(
    @PrimaryKey(autoGenerate = true) var uId: Int?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "genre") var genre: String?,
    @ColumnInfo(name = "seasons") var seasons: Int?,
    @ColumnInfo(name = "creation_date") var creation_date: String?
)