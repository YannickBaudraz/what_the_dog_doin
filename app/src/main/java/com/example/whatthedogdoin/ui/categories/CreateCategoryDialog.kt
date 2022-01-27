package com.example.whatthedogdoin.ui.categories

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.whatthedogdoin.R

class CreateCategoryDialog : AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val inflater = activity?.layoutInflater
        val view = inflater?.inflate(R.layout.fragment_dialog_category, null)

        builder
            .setView(view)
            .setTitle("Ajouter une catégorie")
            .setNegativeButton("Annuler") { _, _ -> }
            .setPositiveButton("Ajouter") { _, _ -> }

        return builder.create()
    }
}