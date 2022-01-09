package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.DownloadViewAdapter
import com.gcect.gcectapp.databinding.ExaminationScheduleListPageBinding
import com.gcect.gcectapp.viewmodels.*

class OddSemScheduleFragment(private val navController: NavController) : Fragment() {
    private lateinit var binding: ExaminationScheduleListPageBinding
    private val viewModel22: SemScheduleViewModel22 by activityViewModels()
    private val viewModel21: SemScheduleViewModel21 by activityViewModels()
    private val viewModel20: SemScheduleViewModel20 by activityViewModels()
    private lateinit var sharedViewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.examination_schedule_list_page, container, false)
        sharedViewModel = ViewModelProvider(
            requireActivity(),
            MainActivityViewModelFactory()
        ).get(MainActivityViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = when(sharedViewModel.examScheduleYear){
            22 -> viewModel22.oddSemList
            21 -> viewModel21.oddSemList
            20 -> viewModel20.oddSemList
            else -> null
        }
        if(list!!.isEmpty()){
            binding.txtDataFoundIndicator.visibility = View.VISIBLE
            binding.rvExamScheduleList.visibility = View.GONE
        } else {
            binding.txtDataFoundIndicator.visibility = View.GONE
            binding.rvExamScheduleList.visibility = View.VISIBLE
            val adapter = DownloadViewAdapter(
                R.id.examScheduleFragment,
                list,
                navController,
                true,
                viewModel22,
                viewModel21,
                viewModel20,
                sharedViewModel
            )
            binding.rvExamScheduleList.layoutManager = LinearLayoutManager(requireContext())
            binding.rvExamScheduleList.adapter = adapter
        }
    }
}