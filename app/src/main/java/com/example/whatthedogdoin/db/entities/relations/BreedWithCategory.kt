package com.example.whatthedogdoin.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Category

data class BreedWithCategory(
    @Embedded val breed: Breed,
    @Relation(
        parentColumn = "idCategory",
        entityColumn = "id"
    )
    val category: Category?
) {
}