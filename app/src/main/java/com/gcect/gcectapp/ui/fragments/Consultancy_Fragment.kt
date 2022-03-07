package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.ConsultancyRecyclerAdapter
import com.gcect.gcectapp.databinding.FragmentConsultancyBinding
import com.gcect.gcectapp.viewmodels.ConsultancyViewmodel


class Consultancy_Fragment : Fragment() {
    lateinit var binding: FragmentConsultancyBinding
    private val consultancyViewmodel: ConsultancyViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_consultancy_, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CollaborationrecyclerViewSetup(binding.rvConsultancy)

    }


    private fun CollaborationrecyclerViewSetup(recyclerView: RecyclerView){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = ConsultancyRecyclerAdapter(requireContext(),consultancyViewmodel.listOfConsultancyDetail)
        recyclerView.adapter = adapter
    }

}