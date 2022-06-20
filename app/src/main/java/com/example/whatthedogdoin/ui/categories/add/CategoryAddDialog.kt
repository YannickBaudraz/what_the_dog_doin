package com.example.whatthedogdoin.ui.categories.add

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.viewModels
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.ui.ViewModelFactory
import com.example.whatthedogdoin.ui.categories.CategoryViewModel


class CategoryAddDialog : AppCompatDialogFragment() {
    private val categoryViewModel: CategoryViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).categoryRepository)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val inflater = activity?.layoutInflater
        val view = inflater?.inflate(R.layout.fragment_category_dialog, null)

        builder
            .setView(view)
            .setTitle("Ajouter une catégorie")
            .setNegativeButton("Annuler") { _, _ -> }
            .setPositiveButton("Ajouter") { _, _ -> onSubmit(view) }

        return builder.create()
    }

    private fun onSubmit(view: View?) {
        val editTextId = R.id.addCategoryText
        val noun = view?.findViewById<EditText>(editTextId)?.text.toString()

        if (noun.isEmpty()) {
            val emptyErrorText = "Veuillez entrer un nom de catégorie"
            Toast.makeText(activity, emptyErrorText, Toast.LENGTH_LONG).show()
        } else {
            val category = Category(noun = noun)
            categoryViewModel.insert(category)
        }
    }
}