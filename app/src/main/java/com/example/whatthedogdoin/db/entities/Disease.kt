package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diseases")
data class Disease (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Int = 0,
    @ColumnInfo var noun: String,
    @ColumnInfo var description: String,
    @ColumnInfo var symptoms: String,
    @ColumnInfo var preventive: String,
    @ColumnInfo var curative: String,
    @ColumnInfo val vaccinable: Boolean,
    @ColumnInfo val zoonosis: Boolean
)