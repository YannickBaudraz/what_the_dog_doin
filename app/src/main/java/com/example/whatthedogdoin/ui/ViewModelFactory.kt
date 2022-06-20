package com.example.whatthedogdoin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.repositories.AbstractRepository
import com.example.whatthedogdoin.repositories.BreedRepository
import com.example.whatthedogdoin.repositories.CategoryRepository
import com.example.whatthedogdoin.repositories.ClientRepository
import com.example.whatthedogdoin.repositories.DogRepository
import com.example.whatthedogdoin.ui.breeds.BreedViewModel
import com.example.whatthedogdoin.ui.categories.CategoryViewModel
import com.example.whatthedogdoin.ui.clients.ClientViewModel
import com.example.whatthedogdoin.ui.dogs.DogViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: AbstractRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClientViewModel(repository as ClientRepository) as T
        } else if (modelClass.isAssignableFrom(BreedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BreedViewModel(repository as BreedRepository) as T
        } else if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(repository as CategoryRepository) as T
        } else if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DogViewModel(repository as DogRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}