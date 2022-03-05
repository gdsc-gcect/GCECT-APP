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
import com.gcect.gcectapp.databinding.TheInstituteViewFragmentBinding

class TheInstituteViewFragment: Fragment() {
    private lateinit var binding: TheInstituteViewFragmentBinding
    private val instituteImgUrl = "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/About%20Us%2FThe%20Institute%2Fimg%2001.jpg?alt=media&token=9482f052-a36a-4828-ac34-7a0a77e7ff3f"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.the_institute_view_fragment, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtPageTitle.text = "The Institute"
        val progressbar: ProgressBar = binding.imgProgressBar
        val instituteImg = binding.gcectAboutUsImage
        Glide.with(requireContext()).load(instituteImgUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    progressbar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Failed to load image...", Toast.LENGTH_SHORT).show()
                    return false
                }
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progressbar.visibility = View.GONE
                    return false
                }

            })
            .into(instituteImg)
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