package com.example.whatthedogdoin.ui.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.databinding.FragmentDogsBinding

class DogsFragment : Fragment() {

    private lateinit var dogsViewModel: DogsViewModel
    private var _binding: FragmentDogsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dogsViewModel =
                ViewModelProvider(this).get(DogsViewModel::class.java)

        _binding = FragmentDogsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDogs
        dogsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}