package com.example.whatthedogdoin.ui.diseases

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatthedogdoin.R

class diseaseDetails : Fragment() {

    companion object {
        fun newInstance() = diseaseDetails()
    }

    private lateinit var viewModel: DiseaseDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_disease_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiseaseDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}