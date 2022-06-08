package com.example.whatthedogdoin.db.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.whatthedogdoin.db.entities.*

data class DogWithBreedAndDiseases(
    @Embedded val dog: Dog,
    @Relation(
        parentColumn = "breed",
        entityColumn = "id"
    )
    val breed: Breed,
    @Relation(
        parentColumn = "crossbreed",
        entityColumn = "id"
    )
    val crossbreed: Breed?,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(DogHaveDisease::class)
    )
    val diseases: List<Disease>
) {
}