package com.example.whatthedogdoin.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.repositories.CategoryRepository

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is categories Fragment"
    }
    val text: LiveData<String> = _text

    val allCategories: LiveData<List<Category>> = repository.allCategories.asLiveData()
}