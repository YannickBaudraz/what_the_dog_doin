package com.example.whatthedogdoin.ui.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.db.entities.Dog
import com.example.whatthedogdoin.db.entities.relations.DogWithClientAndBreed
import com.example.whatthedogdoin.ui.ViewModelFactory
import java.util.*

class DogDetailFragment : Fragment() {

    private val dogViewModel: DogViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).dogRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_dog_detail, container, false)
        val goBackButton: ImageButton = root.findViewById(R.id.dogGoBack)
        val deleteButton: ImageButton = root.findViewById(R.id.dogDelete)

        val masterLabel: TextView = root.findViewById(R.id.master)
        val breedLabel: TextView = root.findViewById(R.id.breed)

        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val dogLiveData = dogViewModel.findDogWithClientAndBreedById(id)

        goBackButton.setOnClickListener() {
            goBack()
        }

        deleteButton.setOnClickListener() {
            dogLiveData.value?.let { it -> dogViewModel.delete(it.dog) }
            goBack()
        }

        masterLabel.setOnClickListener {
            val bundle = bundleOf(Constants.ID_KEY to dogLiveData.value?.client?.id)
            masterLabel.findNavController().navigate(R.id.action_dog_to_clientDetail, bundle)
        }

        breedLabel.setOnClickListener {
            val bundle = bundleOf(Constants.ID_KEY to dogLiveData.value?.breed?.id)
            breedLabel.findNavController().navigate(R.id.action_dog_to_breedDetail, bundle)
        }

        dogLiveData.observe(viewLifecycleOwner) { dog ->
            root.findViewById<TextView>(R.id.name).text = dog?.dog?.noun
            masterLabel.text = dog?.client?.firstname + " " + dog?.client?.lastname
            breedLabel.text = dog?.crossbreed?.noun ?: dog?.breed?.noun
            root.findViewById<TextView>(R.id.gender).text = if (dog.dog.female) "Femelle" else "Mâle"
            root.findViewById<TextView>(R.id.sterilized).text = if (dog.dog.sterilized) "Oui" else "Non"
        }

        return root
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }
}