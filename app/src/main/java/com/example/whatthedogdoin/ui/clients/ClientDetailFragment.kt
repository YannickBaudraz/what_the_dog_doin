package com.example.whatthedogdoin.ui.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.ui.ViewModelFactory

class ClientDetailFragment : Fragment() {

    private val clientViewModel: ClientViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).clientRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_client_detail, container, false)
        val goBackButton: ImageButton = root.findViewById(R.id.breedGoBack)
        val deleteButton: ImageButton = root.findViewById(R.id.buttonDeleteBreed)
        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val clientLiveData = clientViewModel.findClientWithLocalityAndDogWithBreedAndDiseasesById(id)

        goBackButton.setOnClickListener() {
            goBack()
        }

        deleteButton.setOnClickListener() {
            clientLiveData.value?.let { it -> clientViewModel.delete(it.client) }
            goBack()
        }

        clientLiveData.observe(viewLifecycleOwner) { client ->
            root.findViewById<TextView>(R.id.firstname).text = client.client.firstname
            root.findViewById<TextView>(R.id.lastname).text = client.client.lastname
            root.findViewById<TextView>(R.id.dog).text = client.dogs.get(0).crossbreed?.noun ?: client.dogs.get(0).breed.noun
        }

        return root
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }
}