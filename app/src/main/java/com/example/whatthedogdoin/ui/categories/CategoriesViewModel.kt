package com.example.whatthedogdoin.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.repositories.CategoryRepository

class CategoriesViewModel(private val repository: CategoryRepository) : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Categories"
    }
    val text: LiveData<String> = _text
    val allCategories: LiveData<List<Category>> = repository.allCategories.asLiveData()
}