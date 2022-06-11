package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breeds")
data class Breed (
    @ColumnInfo(name = "link") val link: String?,
    @ColumnInfo(name = "picture") val picture: String?,
    @ColumnInfo(name = "noun") val noun: String,
    @ColumnInfo(name = "id_category") val idCategory: Int?,
    @ColumnInfo(name = "morphotype") var morphotype: String?,
    @ColumnInfo(name = "classification") var classification: String?,
    @ColumnInfo(name = "min_size_female") val minimumSizeFemale: Int?,
    @ColumnInfo(name = "max_size_female") val maximumSizeFemale: Int?,
    @ColumnInfo(name = "min_size_male") val minimumSizeMale: Int?,
    @ColumnInfo(name = "max_size_male") val maximumSizeMale: Int?,
    @ColumnInfo(name = "min_weight_female") val minimumWeightFemale: Int?,
    @ColumnInfo(name = "max_weight_female") val maximumWeightFemale: Int?,
    @ColumnInfo(name = "min_weight_male") val minimumWeightMale: Int?,
    @ColumnInfo(name = "max_weight_male") val maximumWeightMale: Int?,
    @ColumnInfo(name = "life_expectancy") var lifeExpectancy: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}