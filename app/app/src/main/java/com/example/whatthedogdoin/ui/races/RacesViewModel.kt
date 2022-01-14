package com.example.whatthedogdoin.ui.races

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RacesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is races Fragment"
    }
    val text: LiveData<String> = _text
}