package com.example.whatthedogdoin.ui.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whatthedogdoin.databinding.FragmentClientsBinding

class ClientsFragment : Fragment() {

    private lateinit var clientsViewModel: ClientsViewModel
    private var _binding: FragmentClientsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        clientsViewModel =
                ViewModelProvider(this).get(ClientsViewModel::class.java)

        _binding = FragmentClientsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textClients
        clientsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}