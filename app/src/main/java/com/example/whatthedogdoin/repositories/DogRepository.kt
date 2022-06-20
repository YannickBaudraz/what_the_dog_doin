package com.example.whatthedogdoin.repositories

import androidx.annotation.WorkerThread
import com.example.whatthedogdoin.db.dao.DogDao
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Dog
import kotlinx.coroutines.flow.Flow

class DogRepository(private val dogDao: DogDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allDogs: Flow<List<Dog>> = dogDao.all()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dog: Dog) {
        dogDao.insert(dog)
    }

    @WorkerThread
    suspend fun find(id: Int): Dog {
        return dogDao.find(id)
    }

    @WorkerThread
    suspend fun update(dog: Dog) {
        dogDao.update(dog)
    }

    @WorkerThread
    suspend fun delete(dog: Dog) {
        dogDao.delete(dog)
    }
}