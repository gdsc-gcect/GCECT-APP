package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.StaticTextFragmentsWithYellowBackgroundBinding
import com.gcect.gcectapp.ui.activity.MainActivity

class PlacementOverViewFragment : Fragment() {
    private lateinit var binding: StaticTextFragmentsWithYellowBackgroundBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.static_text_fragments_with_yellow_background, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pageTitle = "Placement Overview"
        binding.pageDesc = getString(R.string.placement_overview_p)

        onBackPressed()
    }
    /**
     * handling back press from fragments
     */
    private fun onBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Do custom work here
                    navigate(
                        R.id.homeFragment
                    )
                    setWhiteHamburgerIcon()
                }
            }
            )
    }

    /**
     * For handling navigation
     */
    private fun navigate(navFragId: Int) {
        val id = findNavController().currentDestination?.id
        findNavController().popBackStack(id!!, true)
        findNavController().navigate(navFragId)
    }

    /**
     * For setting the white hamburger icon
     */
    private fun setWhiteHamburgerIcon() {
        MainActivity.iconHamburger!!.setImageResource(R.drawable.hamburger_icon_white)
    }
}