package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class Service (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val id: Int,
    @ColumnInfo val moment: String,
    @ColumnInfo val duration: Float,
    @ColumnInfo val type: String,
    @ColumnInfo val description: String?,
    @ColumnInfo val street: String?,
    @ColumnInfo(name = "id_locality") val idLocality: Int,
)