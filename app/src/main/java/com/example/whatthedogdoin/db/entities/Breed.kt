package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breeds")
data class Breed (
    @ColumnInfo(name = "link") val link: String?,
    @ColumnInfo(name = "noun") val noun: String,
    @ColumnInfo(name = "id_category") val idCategory: Int?,
    @ColumnInfo(name = "morphotype") var morphotype: String?,
    @ColumnInfo(name = "classification") var classification: String?,
    @ColumnInfo(name = "average_size_female") val averageSizeFemale: Int?,
    @ColumnInfo(name = "average_size_male") val averageSizeMale: Int?,
    @ColumnInfo(name = "average_weight_female") val averageWeightFemale: Int?,
    @ColumnInfo(name = "average_weight_male") val averageWeightMale: Int?,
    @ColumnInfo(name = "life_expectancy") var lifeExpectancy: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}