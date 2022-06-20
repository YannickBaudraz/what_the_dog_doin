package com.example.whatthedogdoin.ui.clients

import androidx.lifecycle.*
import com.example.whatthedogdoin.db.entities.Client
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocality
import com.example.whatthedogdoin.db.entities.relations.ClientWithLocalityAndDogWithBreedAndDiseases
import com.example.whatthedogdoin.repositories.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {

    val allClientsWithLocalities: LiveData<List<ClientWithLocality>> = repository.allClientsWithLocalities.asLiveData()

    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }

    fun findClientWithLocalityAndDogWithBreedAndDiseasesById(id: Int): LiveData<ClientWithLocalityAndDogWithBreedAndDiseases> {
        val currentClient = MutableLiveData<ClientWithLocalityAndDogWithBreedAndDiseases>()
        viewModelScope.launch {
            currentClient.value = repository.findClientWithLocalityAndDogWithBreedAndDiseasesById(id)
        }
        return currentClient
    }

    fun update(client: Client) = viewModelScope.launch {
        repository.update(client)
    }

    fun delete(client: Client) = viewModelScope.launch {
        repository.delete(client)
    }
}