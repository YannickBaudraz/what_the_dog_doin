package com.example.whatthedogdoin.repositories

import androidx.annotation.WorkerThread
import com.example.whatthedogdoin.db.dao.DiseaseDao
import com.example.whatthedogdoin.db.entities.Client
import com.example.whatthedogdoin.db.entities.Disease
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import kotlinx.coroutines.flow.Flow

class DiseaseRepository(private val diseaseDao: DiseaseDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allDiseases: Flow<List<Disease>> = diseaseDao.getDiseases()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(disease: Disease) {
        diseaseDao.insert(disease)
    }
    @WorkerThread
    suspend fun getDisease(id: Int): Disease {
        return diseaseDao.getDisease(id)
    }
    @WorkerThread
    suspend fun delete(disease: Disease) {
        diseaseDao.delete(disease)
    }
}