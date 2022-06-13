package com.example.whatthedogdoin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_take_services")
data class ClientTakeService (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Int = 0,
    @ColumnInfo(name = "id_client") val idClient: Int,
    @ColumnInfo(name = "id_service") val idService: Int,
    @ColumnInfo val paid: Boolean
)