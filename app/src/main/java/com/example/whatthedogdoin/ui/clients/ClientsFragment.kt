package com.example.whatthedogdoin.ui.clients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatthedogdoin.R
import com.example.whatthedogdoin.WhatTheDogDoinApplication
import com.example.whatthedogdoin.ui.ViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ClientsFragment : Fragment() {

    private val clientViewModel: ClientViewModel by viewModels {
        ViewModelFactory((requireActivity().application as WhatTheDogDoinApplication).clientRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_clients, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.client_recyclerview)
        val adapter = ClientListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        /*clientViewModel.allClients.observe(viewLifecycleOwner) { clients ->
            clients.let { adapter.submitList(it) }
        } // */

        clientViewModel.allClientsWithLocalities.observe(viewLifecycleOwner) { clients ->
            clients.let { adapter.submitList(it) }
        }

        return root
    }
}