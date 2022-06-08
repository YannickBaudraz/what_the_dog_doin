package com.example.whatthedogdoin.ui.dogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatthedogdoin.db.entities.Dog
import com.example.whatthedogdoin.repositories.DogRepository

class DogsViewModel(private val repository: DogRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dogs Fragment"
    }
    val text: LiveData<String> = _text

    private val dogs = MutableLiveData<List<Dog>>()
}
