package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diseases")
data class Disease (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Int = 0,
    @ColumnInfo val noun: String,
    @ColumnInfo val description: String,
    @ColumnInfo val symptoms: String,
    @ColumnInfo val preventive: String,
    @ColumnInfo val curative: String,
    @ColumnInfo val vaccinable: Boolean,
    @ColumnInfo val zoonosis: Boolean
)