package com.example.whatthedogdoin.ui.diseases

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatthedogdoin.R

class DiseaseForm : Fragment() {

    companion object {
        fun newInstance() = DiseaseForm()
    }

    private lateinit var viewModel: DiseaseFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_disease_form, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiseaseFormViewModel::class.java)
        // TODO: Use the ViewModel
    }

}