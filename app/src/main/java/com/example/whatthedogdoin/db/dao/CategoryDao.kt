package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getCategories(): Flow<List<Category>>

    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategory(id: Int): Category

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dog: Category)

    @Update
    suspend fun updateCategories(vararg dogs: Category)

    @Delete
    suspend fun deleteCategories(vararg dogs: Category)
}