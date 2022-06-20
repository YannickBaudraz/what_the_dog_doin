package com.example.whatthedogdoin.ui.diseases

import androidx.lifecycle.*
import com.example.whatthedogdoin.db.entities.Disease
import com.example.whatthedogdoin.repositories.DiseaseRepository
import kotlinx.coroutines.launch

class DiseaseViewModel(private val repository: DiseaseRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Maladies"
    }
    val allDiseases: LiveData<List<Disease>> = repository.allDiseases.asLiveData()

    fun getDisease(id: Int): LiveData<Disease> {
        val currentDisease = MutableLiveData<Disease>()
        viewModelScope.launch {
            currentDisease.value = repository.getDisease(id)
        }
        return currentDisease
    }
    fun update(disease: Disease) = viewModelScope.launch {
        repository.update(disease)
    }
    fun delete(disease: Disease) = viewModelScope.launch {
        repository.delete(disease)
    }
}