package com.example.whatthedogdoin.ui.diseases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.Constants
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.ui.ViewModelFactory


class DiseaseDetailsFragment : Fragment() {

    private val diseaseViewModel: DiseaseViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).diseaseRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_disease_details, container, false)
        val goBackButton: ImageButton = root.findViewById(R.id.diseaseGoBack)
        val deleteButton: ImageButton = root.findViewById(R.id.buttonDeleteDisease)
        val id = arguments?.getInt(Constants.ID_KEY) ?: 0
        val diseaseLiveData = diseaseViewModel.getDisease(id)

        goBackButton.setOnClickListener() {
            goBack()
        }

        deleteButton.setOnClickListener() {
            diseaseLiveData.value?.let { it -> diseaseViewModel.delete(it) }
            goBack()
        }

        diseaseLiveData.observe(viewLifecycleOwner) { disease ->
            root.findViewById<TextView>(R.id.textAddSickness).text = disease.noun
            root.findViewById<TextView>(R.id.textDescription).text = disease.description
            if(disease.vaccinable){
                root.findViewById<TextView>(R.id.iconVaccineStatus).text = "✔"
            } else {
                root.findViewById<TextView>(R.id.iconVaccineStatus).text = "❌"
            }
            if(disease.zoonosis){
                root.findViewById<TextView>(R.id.iconZoonoseStatus).text = "✔"
            } else {
                root.findViewById<TextView>(R.id.iconZoonoseStatus).text = "❌"
            }
        }

        return root
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }
}