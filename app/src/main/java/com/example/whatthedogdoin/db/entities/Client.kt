package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class Client (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Int = 0,
    @ColumnInfo val firstname: String,
    @ColumnInfo val lastname: String,
    @ColumnInfo val female: Boolean,
    @ColumnInfo val email: String?,
    @ColumnInfo val phone: String,
    @ColumnInfo val street: String?,
    @ColumnInfo(name = "id_locality") var idLocality: Int?,
)