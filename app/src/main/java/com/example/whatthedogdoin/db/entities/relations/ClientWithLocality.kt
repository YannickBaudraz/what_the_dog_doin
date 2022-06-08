package com.example.whatthedogdoin.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.whatthedogdoin.db.entities.*

data class ClientWithLocality(
    @Embedded val client: Client,
    @Relation(
        parentColumn = "id_locality",
        entityColumn = "id"
    )
    val locality: Locality?
) {
}