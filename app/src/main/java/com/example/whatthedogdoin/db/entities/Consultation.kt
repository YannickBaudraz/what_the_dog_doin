package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consultations")
data class Consultation(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Int = 0,
    @ColumnInfo val situation: String,
    @ColumnInfo val goal: String?,
    @ColumnInfo val deadline: String?,
    @ColumnInfo val solution: String?,
    @ColumnInfo val medicines: String?,
    @ColumnInfo val argumentation: String?,
    @ColumnInfo(name = "id_service") val idService: Int
)