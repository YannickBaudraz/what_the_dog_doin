package com.example.whatthedogdoin.ui.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.ui.ViewModelFactory

class DogDetailFragment : Fragment() {

    private val dogViewModel: DogViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).dogRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_dog_detail, container, false)
        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val dogLiveData = dogViewModel.find(id)

        return root
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }
}