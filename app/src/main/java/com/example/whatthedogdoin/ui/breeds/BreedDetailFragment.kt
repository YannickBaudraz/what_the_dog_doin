package com.example.whatthedogdoin.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.ui.ViewModelFactory

class BreedDetailFragment : Fragment() {

    private val breedViewModel: BreedViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).breedRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_breed_detail, container, false)

        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val breedLiveData = breedViewModel.find(id)
        breedLiveData.observe(viewLifecycleOwner) { breed ->
            root.findViewById<TextView>(R.id.text_id).text = breed.noun ?: breed.noun
        }

        return root
    }
}