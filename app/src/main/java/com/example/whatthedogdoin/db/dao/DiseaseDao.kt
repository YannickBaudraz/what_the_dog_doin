package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Client
import com.example.whatthedogdoin.db.entities.Disease
import kotlinx.coroutines.flow.Flow

@Dao
interface DiseaseDao {

    @Query("SELECT * FROM diseases")
    fun getDiseases(): Flow<List<Disease>>

    @Query("SELECT * FROM diseases WHERE id = :id")
    suspend fun getDisease(id: Int): Disease

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(disease: Disease)

    @Delete(entity = Disease::class)
    suspend fun delete(disease: Disease)

    @Update
    suspend fun updateDisease(vararg disease: Disease)

    @Delete
    suspend fun deleteDisease(vararg disease: Disease)
}