package com.example.whatthedogdoin.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.ui.ViewModelFactory

class BreedsFragment : Fragment() {

    private val breedViewModel: BreedViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).breedRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_breeds, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.breed_recyclerview)
        val adapter = BreedListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        /*clientViewModel.allClients.observe(viewLifecycleOwner) { clients ->
            clients.let { adapter.submitList(it) }
        } // */

        breedViewModel.allBreeds.observe(viewLifecycleOwner) { breeds ->
           breeds.let { adapter.submitList(it) }
        }

        return root
    }
}