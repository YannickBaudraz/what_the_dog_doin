package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Breed;
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {
    @Query("SELECT * FROM breeds ORDER BY noun COLLATE NOCASE")
    fun getBreeds(): Flow<List<Breed>>

    @Query("SELECT * FROM breeds WHERE id = :id")
    suspend fun find(id: Int): Breed

    @Query("SELECT * FROM breeds WHERE id = :id")
    suspend fun getBreed(id: Int): Breed

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(breed: Breed)

    @Update(entity = Breed::class)
    suspend fun update(breed: Breed)

    @Update
    suspend fun updateBreeds(vararg breeds: Breed)

    @Delete(entity = Breed::class)
    suspend fun delete(breed: Breed)

    @Delete
    suspend fun deleteBreeds(vararg breeds: Breed)
}