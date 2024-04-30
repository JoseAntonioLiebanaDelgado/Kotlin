package com.example.mangashelfv2.ROOM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Manga(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "nombre") var nombre: String?,
    @ColumnInfo(name = "numVolumenes") var numVolumenes: Int?,
    @ColumnInfo(name = "autor") var autor: String?,
    @ColumnInfo(name = "editorial") var editorial: String?,
    @ColumnInfo(name = "descripcion") var descripcion: String?,
    @ColumnInfo(name = "imgURL") var imgURL: String?
)