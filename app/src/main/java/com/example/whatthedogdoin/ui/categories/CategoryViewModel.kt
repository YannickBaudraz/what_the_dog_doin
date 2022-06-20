package com.example.whatthedogdoin.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.repositories.CategoryRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    val allCategories: LiveData<List<Category>> = repository.allCategories.asLiveData()

    fun insert(category: Category): Job = viewModelScope.launch { repository.insert(category) }
}