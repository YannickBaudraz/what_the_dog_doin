package com.example.whatthedogdoin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.repositories.AbstractRepository
import com.example.whatthedogdoin.repositories.ClientRepository
import com.example.whatthedogdoin.ui.clients.ClientViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: AbstractRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClientViewModel(repository as ClientRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}