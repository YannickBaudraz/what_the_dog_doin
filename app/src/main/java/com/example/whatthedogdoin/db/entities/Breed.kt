package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breeds")
data class Breed (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "picture") val picture: String?,
    @ColumnInfo(name = "additional_info") val additionalInfo: Int?,
    @ColumnInfo(name = "category_id") val categoryId: Int?,
    @ColumnInfo(name = "morphotype") val morphotype: String?,
    @ColumnInfo(name = "average_size") val averageSize: Int?,
) {

}