package com.gcect.gcectapp.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.NssAutoSliderAdapter
import com.gcect.gcectapp.databinding.FragmentNSSBinding
import com.gcect.gcectapp.ui.activity.MainActivity
import com.gcect.gcectapp.utils.Constants
import com.smarteist.autoimageslider.SliderView

class NSSFragment : Fragment() {
    private lateinit var binding: FragmentNSSBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_n_s_s, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nssFragment = this
        val adapter = NssAutoSliderAdapter(requireContext(), Constants.listOfImages)
        setSliderAdapter(adapter)

        onBackPressed()
    }

    private fun setSliderAdapter(adapter: NssAutoSliderAdapter) {

        //to set auto cycle direction in left to
        // right direction you can change according to requirement.
        binding.imageSlider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // to
        // setadapter to sliderview.
        binding.imageSlider.setSliderAdapter(adapter)

        // to set
        // scroll time in seconds.
        binding.imageSlider.scrollTimeInSec = 3

        // to set it scrollable automatically
        binding.imageSlider.isAutoCycle = true

        // to start autocycle.
        binding.imageSlider.startAutoCycle()
    }

    fun onWatchVideoBtnClick() {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(Constants.nssVideoUrl)
        startActivity(i)
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