package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Disease

@Dao
interface DiseaseDao {

    @Query("SELECT * FROM diseases")
    fun getDiseases(): List<Disease>

    @Query("SELECT * FROM diseases WHERE id = :id")
    suspend fun getDisease(id: Int): Disease

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(disease: Disease)

    @Update
    suspend fun updateDisease(vararg disease: Disease)

    @Delete
    suspend fun deleteDisease(vararg disease: Disease)
}