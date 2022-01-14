package com.example.whatthedogdoin.ui.diseases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiseasesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Maladies"
    }
    val text: LiveData<String> = _text // */
}