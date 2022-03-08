package com.gcect.gcectapp.ui.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.VisionMissionViewFragmentBinding

class VisionMissionViewFragment:  Fragment() {
    private lateinit var binding: VisionMissionViewFragmentBinding
    private val visionImgUrl = "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/About%20Us%2FVision%20%26%20Mission%2FIMG01.jpg?alt=media&token=d1711213-ece8-4794-9e17-0061c3162285"
    private val missionImgUrl = "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/About%20Us%2FVision%20%26%20Mission%2FIMG02.jpg?alt=media&token=f6f05ccc-575e-407c-ac05-e819df877068"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.vision_mission_view_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtPageTitle.text = "VISION & MISSION"
        binding.visionImageText.text = getString(R.string.vision_and_mission_p1)
        val progressbarV: ProgressBar = binding.imgProgressBarV
        val progressbarM: ProgressBar = binding.imgProgressBarM
        val visionImg = binding.gcectVisionImage
        val missionImg = binding.gcectMissionImage
        Glide.with(requireContext()).load(visionImgUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    progressbarV.visibility = View.GONE
                    Toast.makeText(requireContext(), "Failed to load image...", Toast.LENGTH_SHORT).show()
                    return false
                }
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progressbarM.visibility = View.GONE
                    return false
                }

            })
            .into(visionImg)
        Glide.with(requireContext()).load(missionImgUrl)
            .listener(object : RequestListener<Drawable>{
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    progressbarM.visibility = View.GONE
                    Toast.makeText(requireContext(), "Failed to load image...", Toast.LENGTH_SHORT).show()
                    return false
                }
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progressbarM.visibility = View.GONE
                    return false
                }

            })
            .into(missionImg)
        onBackPressed()
    }
    private fun onBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Do custom work here
                    navigate(
                        R.id.homeFragment
                    )
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
}