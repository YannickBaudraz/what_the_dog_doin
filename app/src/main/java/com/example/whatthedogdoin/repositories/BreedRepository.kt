package com.example.whatthedogdoin.repositories

import androidx.annotation.WorkerThread
import com.example.whatthedogdoin.db.dao.BreedDao
import com.example.whatthedogdoin.db.entities.Breed
import kotlinx.coroutines.flow.Flow

class BreedRepository(private val breedDao: BreedDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allBreeds: Flow<List<Breed>> = breedDao.getBreeds()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(breed: Breed) {
        breedDao.insert(breed)
    }

    @WorkerThread
    suspend fun find(id: Int): Breed {
        return breedDao.find(id)
    }

    @WorkerThread
    suspend fun update(breed: Breed) {
        breedDao.update(breed)
    }
}