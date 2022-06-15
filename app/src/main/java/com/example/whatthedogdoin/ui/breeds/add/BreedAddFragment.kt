package com.example.whatthedogdoin.ui.breeds.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.whatthedogdoin.R;
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.databinding.FragmentBreedAddBinding
import com.example.whatthedogdoin.databinding.FragmentDogsBinding
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.ui.ViewModelFactory
import com.example.whatthedogdoin.ui.breeds.BreedViewModel
import com.example.whatthedogdoin.ui.categories.CategoryViewModel
import com.google.android.material.button.MaterialButton

/**
 * A simple [Fragment] subclass.
 * Use the [BreedAddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BreedAddFragment : Fragment() {
    private val breedViewModel: BreedViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).breedRepository)
    }
    private val categoryViewModel: CategoryViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).categoryRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_breed_add, container, false)
        val buttonGoBack: ImageButton = root.findViewById(R.id.goBack)
        val buttonSubmit: MaterialButton = root.findViewById(R.id.add)

        val spinner: Spinner = root.findViewById(R.id.category)
        val adapter = BreedAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val item = parent.getItemAtPosition(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        categoryViewModel.allCategories.observe(viewLifecycleOwner, Observer { c ->
            c?.forEach {
                adapter.apply {
                    mCategories.add(it)
                    notifyDataSetChanged()
                }
            }
        })
        spinner.adapter = adapter

        buttonGoBack.setOnClickListener() {
            goBack()
        }

        buttonSubmit.setOnClickListener() {
            val name: String = root.findViewById<EditText>(R.id.name).text.toString()
            val link: String = root.findViewById<EditText>(R.id.link).text.toString()
            val morphotype: String = root.findViewById<EditText>(R.id.morphotype).text.toString()
            val category : Category = spinner.selectedItem as Category
            val classification: String =
                root.findViewById<EditText>(R.id.classification).text.toString()
            val femaleMaxSize: Int =
                root.findViewById<EditText>(R.id.averageFemaleSize).text.toString().toInt()
            val maleMaxSize: Int =
                root.findViewById<EditText>(R.id.averageMaleSize).text.toString().toInt()
            val femaleMaxWeight: Int =
                root.findViewById<EditText>(R.id.averageFemaleWeight).text.toString().toInt()
            val maleMaxWeight: Int =
                root.findViewById<EditText>(R.id.averageMaleWeight).text.toString().toInt()
            val lifeExpectancy: Int =
                root.findViewById<EditText>(R.id.lifeExpectancy).text.toString().toInt()

            val breed = Breed(
                noun = name,
                link = link,
                morphotype = morphotype,
                idCategory = category.id,
                classification = classification,
                averageSizeFemale = femaleMaxSize,
                averageSizeMale = maleMaxSize,
                averageWeightFemale = femaleMaxWeight,
                averageWeightMale = maleMaxWeight,
                lifeExpectancy = lifeExpectancy
            )
            breedViewModel.insert(breed)
            goBack()
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BreedAddFragment.
         */
// TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BreedAddFragment().apply {
            }
    }

    private fun goBack() {
        requireActivity().onBackPressed()
    }
}