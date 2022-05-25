package com.example.whatthedogdoin.repositories

import androidx.annotation.WorkerThread
import com.example.whatthedogdoin.db.dao.CategoryDao
import com.example.whatthedogdoin.db.entities.Category

class CategoryRepository(private val categoryDao: CategoryDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allCategories: List<Category> = categoryDao.getCategories()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(category: Category) {
        categoryDao.insert(category)
    }
}