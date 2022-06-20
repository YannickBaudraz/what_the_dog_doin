package com.example.whatthedogdoin.ui.dogs

import androidx.lifecycle.*
import com.example.whatthedogdoin.db.entities.Dog
import com.example.whatthedogdoin.db.entities.relations.DogWithClientAndBreed
import com.example.whatthedogdoin.repositories.DogRepository
import kotlinx.coroutines.launch

class DogViewModel(private val repository: DogRepository) : ViewModel() {
    val allDogs: LiveData<List<Dog>> = repository.allDogs.asLiveData()

    fun insert(dog: Dog) = viewModelScope.launch {
        repository.insert(dog)
    }

    fun find(id: Int): LiveData<Dog> {
        val currentDog = MutableLiveData<Dog>()
        viewModelScope.launch {
            currentDog.value = repository.find(id)
        }
        return currentDog
    }

    fun findDogWithClientAndBreedById(id: Int): LiveData<DogWithClientAndBreed> {
        val currentDog = MutableLiveData<DogWithClientAndBreed>()
        viewModelScope.launch {
            currentDog.value = repository.findDogWithClientAndBreedById(id)
        }
        return currentDog
    }

    fun update(dog: Dog) = viewModelScope.launch {
        repository.update(dog)
    }

    fun delete(dog: Dog) = viewModelScope.launch {
        repository.delete(dog)
    }
}