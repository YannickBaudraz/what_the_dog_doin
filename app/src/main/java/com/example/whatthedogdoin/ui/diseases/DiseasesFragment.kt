package com.example.whatthedogdoin.ui.diseases

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


class DiseasesFragment : Fragment() {

    private val diseaseViewModel: DiseaseViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).diseaseRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_diseases, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.disease_recyclerview)
        val adapter = DiseaseListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        diseaseViewModel.allDiseases.observe(viewLifecycleOwner) { diseases ->
            diseases.let { adapter.submitList(it) }
        }

        return root
    }
}