package com.example.whatthedogdoin.db.dao

import  androidx.room.*
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Dog
import kotlinx.coroutines.flow.Flow

@Dao
interface DogDao {

    @Query("SELECT * FROM dogs")
    fun all(): Flow<List<Dog>>


    @Query("SELECT * FROM dogs WHERE id = :id")
    suspend fun find(id: Int): Dog

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dog: Dog)

    @Update
    suspend fun update(dog: Dog)

    @Delete
    suspend fun delete(dog: Dog)
}