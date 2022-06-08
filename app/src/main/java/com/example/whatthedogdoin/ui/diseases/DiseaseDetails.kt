package com.example.whatthedogdoin.ui.diseases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.R

class DiseaseDetails : Fragment() {

    companion object {
        fun newInstance() = DiseaseDetails()
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