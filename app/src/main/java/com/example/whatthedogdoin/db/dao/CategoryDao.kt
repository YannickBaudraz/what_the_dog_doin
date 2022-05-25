package com.example.whatthedogdoin.db.dao

import androidx.room.*
import com.example.whatthedogdoin.db.entities.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM Categories")
    fun getCategories(): List<Category>

    @Query("SELECT * FROM Categories WHERE id = :id")
    suspend fun getCategory(id: Int): Category

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dog: Category)

    @Update
    suspend fun updateCategories(vararg dogs: Category)

    @Delete
    suspend fun deleteCategories(vararg dogs: Category)
}