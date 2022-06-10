package com.example.whatthedogdoin.ui.breeds

import androidx.lifecycle.*
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.repositories.BreedRepository
import kotlinx.coroutines.launch

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    val allBreeds: LiveData<List<Breed>> = repository.allBreeds.asLiveData()

    fun insert(breed: Breed) = viewModelScope.launch {
        repository.insert(breed)
    }

    fun find(id: Int): LiveData<Breed> {
        val currentBreed = MutableLiveData<Breed>()
        viewModelScope.launch {
            currentBreed.value = repository.find(id)
        }
        return currentBreed
    }
}
