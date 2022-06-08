package com.example.whatthedogdoin.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.whatthedogdoin.db.entities.*

data class ClientWithLocalityAndDogWithBreedAndDiseases(
    @Embedded val client: Client,
    @Relation(
        parentColumn = "id_locality",
        entityColumn = "id"
    )
    val locality: Locality?,
    @Relation(
        entity = Dog::class,
        parentColumn = "id",
        entityColumn = "id_client"
    )
    val dogs: List<DogWithBreedAndDiseases>
) {
}