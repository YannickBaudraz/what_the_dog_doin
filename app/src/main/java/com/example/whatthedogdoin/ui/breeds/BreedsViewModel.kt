package com.example.whatthedogdoin.ui.breeds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BreedsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is breeds Fragment"
    }
    val text: LiveData<String> = _text
}