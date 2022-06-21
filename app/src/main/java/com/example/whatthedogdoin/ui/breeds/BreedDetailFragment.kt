package com.example.whatthedogdoin.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
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
        val goBackButton: ImageButton = root.findViewById(R.id.breedGoBack)
        val deleteButton: ImageButton = root.findViewById(R.id.buttonDeleteBreed)
        val submitButton: Button = root.findViewById(R.id.buttonBreedUpdate)
        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val breedLiveData = breedViewModel.find(id)

        goBackButton.setOnClickListener() {
            goBack()
        }

        deleteButton.setOnClickListener() {
            breedLiveData.value?.let { it -> breedViewModel.delete(it) }
            goBack()
        }

        submitButton.setOnClickListener() {
            val name: EditText = root.findViewById(R.id.name)
            val morphotype: EditText = root.findViewById(R.id.morphotype)
            val classification: EditText = root.findViewById(R.id.classification)
            val lifeExpectancy: EditText = root.findViewById(R.id.lifeExpectancy)

            breedLiveData.value?.noun = name.text.toString()
            breedLiveData.value?.morphotype = morphotype.text.toString()
            breedLiveData.value?.classification = classification.text.toString()
            breedLiveData.value?.lifeExpectancy = lifeExpectancy.text.toString().toInt()

            breedLiveData.value?.let { it -> breedViewModel.update(it) }

            goBack()
        }

        breedLiveData.observe(viewLifecycleOwner) { breed ->
            root.findViewById<TextView>(R.id.name).text = breed.noun
            root.findViewById<TextView>(R.id.morphotype).text = breed.morphotype
            root.findViewById<TextView>(R.id.classification).text = breed.classification
            root.findViewById<TextView>(R.id.lifeExpectancy).text = breed.lifeExpectancy.toString()
        }

        return root
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }
}