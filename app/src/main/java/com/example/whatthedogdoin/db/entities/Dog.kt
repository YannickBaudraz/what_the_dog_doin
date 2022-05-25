package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dogs")
data class Dog(
    @PrimaryKey(autoGenerate = true) @ColumnInfo val id: Int,
    @ColumnInfo val noun: String,
    @ColumnInfo val female: Boolean,
    @ColumnInfo val birthdate: Date,
    @ColumnInfo val sterilized: Boolean,
    @ColumnInfo val chemical: Boolean,
    @ColumnInfo val color: String?,
    @ColumnInfo val dead: Boolean,
    @ColumnInfo val breed: Int,
    @ColumnInfo val crossbreed: Int?,
    @ColumnInfo(name = "id_client") val idClient: Int
) {
}
