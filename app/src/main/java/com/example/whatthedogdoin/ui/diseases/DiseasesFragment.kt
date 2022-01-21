package com.example.whatthedogdoin.ui.diseases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.databinding.FragmentDiseasesBinding

class DiseasesFragment : Fragment() {

    private lateinit var diseasesViewModel: DiseasesViewModel
    private var _binding: FragmentDiseasesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        diseasesViewModel = ViewModelProvider(this).get(DiseasesViewModel::class.java)

        _binding = FragmentDiseasesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDiseases
        diseasesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        }) // */
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}