package com.example.whatthedogdoin.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private lateinit var categoriesViewModel: CategoriesViewModel
    private var _binding: FragmentCategoriesBinding? = null

    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()

        val orderBy = resources.getStringArray(R.array.category_sort)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, orderBy)
        binding.spnOrderBy.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        categoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        val button = _binding!!.floatingActionButton2
        button.setOnClickListener { openDialog() }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openDialog() {
        val createCategoryDialog = CreateCategoryDialog()
        createCategoryDialog.showNow(parentFragmentManager, "Créer catégorie")
    }
}