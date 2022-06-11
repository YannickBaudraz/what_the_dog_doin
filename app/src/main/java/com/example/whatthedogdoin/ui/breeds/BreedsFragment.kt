package com.example.whatthedogdoin.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.ui.ViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BreedsFragment : Fragment() {

    private val breedViewModel: BreedViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).breedRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_breeds, container, false)
        val addBreedButton: FloatingActionButton = root.findViewById(R.id.buttonAddBreed)

        val recyclerView = root.findViewById<RecyclerView>(R.id.breed_recyclerview)
        val adapter = BreedListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        breedViewModel.allBreeds.observe(viewLifecycleOwner) { breeds ->
           breeds.let { adapter.submitList(it) }
        }

        addBreedButton.setOnClickListener {
            addBreedButton.findNavController().navigate(R.id.action_breed_to_breedAdd)
        }

        return root
    }
}