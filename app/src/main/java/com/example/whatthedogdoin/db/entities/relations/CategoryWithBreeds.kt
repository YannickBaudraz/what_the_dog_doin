package com.example.whatthedogdoin.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Category

data class CategoryWithBreeds(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "idCategory"
    )
    val breeds: List<Breed>
)