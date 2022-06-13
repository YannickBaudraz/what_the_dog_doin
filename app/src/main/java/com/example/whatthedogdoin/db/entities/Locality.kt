package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localities")
data class Locality (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val id: Int,
    @ColumnInfo val noun: String,
    @ColumnInfo val zip: Int,
    @ColumnInfo(name = "zip_complement") val zipComplement: Int,
    @ColumnInfo val toponym: String,
    @ColumnInfo val department: String,
    @ColumnInfo val language: String
)