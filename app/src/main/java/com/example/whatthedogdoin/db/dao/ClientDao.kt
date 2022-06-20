package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Client
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocality
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Transaction
    @Query("SELECT * FROM clients")
    suspend fun getClientWithLocalityAndDogWithBreedAndDiseases(): List<ClientWithLocalityAndDogWithBreedAndDiseases>

    @Transaction
    @Query("SELECT * FROM clients WHERE id = :id")
    suspend fun findClientWithLocalityAndDogWithBreedAndDiseasesById(id: Int): ClientWithLocalityAndDogWithBreedAndDiseases

    @Query("SELECT * FROM clients")
    fun getClients() : Flow<List<Client>>

    @Transaction
    @Query("SELECT * FROM clients")
    fun getClientsWithLocalities() : Flow<List<ClientWithLocality>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(client: Client)

    @Update(entity = Client::class)
    suspend fun update(vararg clients: Client)

    @Delete(entity = Client::class)
    suspend fun delete(client: Client)

    @Delete
    suspend fun deleteDogs(vararg clients: Client)
}