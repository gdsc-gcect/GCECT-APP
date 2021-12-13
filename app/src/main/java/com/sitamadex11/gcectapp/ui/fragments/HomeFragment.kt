package com.sitamadex11.gcectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.sitamadex11.gcectapp.R
import com.sitamadex11.gcectapp.adapters.HomeBottomSheetRecyclerAdapter
import com.sitamadex11.gcectapp.adapters.HomeGateRankerRecyclerAdapter
import com.sitamadex11.gcectapp.adapters.HomeNoticeRecyclerAdapter
import com.sitamadex11.gcectapp.databinding.FragmentHomeBinding
import com.sitamadex11.gcectapp.viewmodels.HomeFragmentViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    //#1 Defining a BottomSheetBehavior instance
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //#2 Initializing the BottomSheetBehavior
        val bottomSheetLayout = binding.layoutBottomSheet
        val bottomSheetView: View =
            LayoutInflater.from(context)
                .inflate(
                    R.layout.home_page_bottom_sheet,
                    null
                )
        bottomSheetBehavior =
            BottomSheetBehavior.from(bottomSheetLayout as LinearLayout)

        /**
         * for notice list showing
         */
        val noticeAdapter = HomeNoticeRecyclerAdapter()
        binding.rvNotice.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.rvNotice.adapter = noticeAdapter

        /**
         * for gate ranker list showing
         */
        val gateRankerAdapter = HomeGateRankerRecyclerAdapter()
        binding.rvGateRanker.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        binding.rvGateRanker.adapter = gateRankerAdapter

        /**
         * for gate ranker list showing
         */
        val generalNoticeAdapter = HomeBottomSheetRecyclerAdapter()
        val rvGeneralNotice = binding.layoutBottomSheet.rootView.findViewById<RecyclerView>(R.id.rvGeneralNotice)
        rvGeneralNotice.layoutManager = LinearLayoutManager(requireContext())
        rvGeneralNotice.adapter = generalNoticeAdapter
    }
}
