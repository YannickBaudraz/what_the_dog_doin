package com.example.whatthedogdoin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.repositories.AbstractRepository
import com.example.whatthedogdoin.repositories.BreedRepository
import com.example.whatthedogdoin.repositories.ClientRepository
import com.example.whatthedogdoin.repositories.DiseaseRepository
import com.example.whatthedogdoin.ui.breeds.BreedViewModel
import com.example.whatthedogdoin.ui.clients.ClientViewModel
import com.example.whatthedogdoin.ui.diseases.DiseaseViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: AbstractRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClientViewModel(repository as ClientRepository) as T
        } else if (modelClass.isAssignableFrom(BreedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BreedViewModel(repository as BreedRepository) as T
        }else if (modelClass.isAssignableFrom(DiseaseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiseaseViewModel(repository as DiseaseRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}