package com.example.whatthedogdoin.repositories

import androidx.annotation.WorkerThread
import com.example.whatthedogdoin.db.dao.ClientDao
import com.example.whatthedogdoin.db.entities.Client
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocality
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import kotlinx.coroutines.flow.Flow

class ClientRepository(private val clientDao: ClientDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allClients: Flow<List<Client>> = clientDao.getClients()

    val allClientsWithLocalities: Flow<List<ClientWithLocality>> = clientDao.getClientsWithLocalities()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(client: Client) {
        clientDao.insert(client)
    }

    @WorkerThread
    suspend fun findClientWithLocalityAndDogWithBreedAndDiseasesById(id: Int): ClientWithLocalityAndDogWithBreedAndDiseases {
        return clientDao.findClientWithLocalityAndDogWithBreedAndDiseasesById(id)
    }
}