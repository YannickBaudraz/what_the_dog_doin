package com.example.whatthedogdoin.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.repositories.CategoryRepository

class CategoryViewModel(repository: CategoryRepository) : ViewModel() {

    val allCategories: LiveData<List<Category>> = repository.allCategories.asLiveData()
}