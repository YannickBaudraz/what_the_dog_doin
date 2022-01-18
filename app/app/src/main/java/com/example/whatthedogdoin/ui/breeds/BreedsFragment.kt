package com.example.whatthedogdoin.ui.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.databinding.FragmentBreedsBinding
import com.example.whatthedogdoin.R;

class BreedsFragment : Fragment() {

    private lateinit var breedsViewModel: BreedsViewModel
    private var _binding: FragmentBreedsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()

        val orderBy = resources.getStringArray(R.array.breeds_sort);
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, orderBy);
        binding.autoCompleteTextView.setAdapter(arrayAdapter);
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        breedsViewModel =
                ViewModelProvider(this).get(BreedsViewModel::class.java)

        _binding = FragmentBreedsBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}