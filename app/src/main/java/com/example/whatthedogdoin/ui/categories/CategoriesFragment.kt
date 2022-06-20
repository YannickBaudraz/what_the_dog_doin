package com.example.whatthedogdoin.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.ui.ViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CategoriesFragment : Fragment() {

    private val categoryViewModel: CategoryViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).categoryRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_categories, container, false)

        val orderBy = resources.getStringArray(R.array.category_sort)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, orderBy)
        root.findViewById<AutoCompleteTextView>(R.id.spnOrderBy).setAdapter(arrayAdapter)

        val recyclerView = root.findViewById<RecyclerView>(R.id.category_recyclerview)
        val adapter = CategoryListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        categoryViewModel.allCategories.observe(viewLifecycleOwner) { categories ->
            categories.let { adapter.submitList(it) }
        }

        val addCategoryButton: FloatingActionButton = root.findViewById(R.id.buttonAddCategory)
        addCategoryButton.setOnClickListener { openDialog() }

        return root
    }

    private fun openDialog() {
        val createCategoryDialog = CreateCategoryDialog()
        createCategoryDialog.showNow(parentFragmentManager, "Créer catégorie")
    }
}