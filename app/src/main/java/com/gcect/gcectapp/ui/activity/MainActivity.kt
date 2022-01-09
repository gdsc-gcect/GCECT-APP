package com.gcect.gcectapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.NavBaseRecyclerAdapter
import com.gcect.gcectapp.databinding.ActivityMainBinding
import com.gcect.gcectapp.viewmodels.MainActivityViewModel
import com.gcect.gcectapp.viewmodels.MainActivityViewModelFactory
import com.gcect.gcectapp.adapters.HomeAutoSliderAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    //auto img slider
    lateinit var sliderView: SliderView
    var images = intArrayOf(
        R.drawable.sliderimage,
        R.drawable.sliderimage2,
        R.drawable.sliderimage3
//        android.R.drawable.four,
//        android.R.drawable.five,
//        android.R.drawable.six
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(
            this,
            MainActivityViewModelFactory()
        ).get(MainActivityViewModel::class.java)
        // finding the navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.nav_base_recycler_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter =
            NavBaseRecyclerAdapter(this, navController, binding.imgHamburger, binding.drawerLayout,viewModel)
        adapter.updateList(viewModel.mainList)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        binding.imgHamburger.setOnClickListener(this)
        binding.imgClose.setOnClickListener(this)

        //auto image slider
        sliderView = findViewById(R.id.image_slider)

        val sliderAdapter = HomeAutoSliderAdapter(images)

        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView.startAutoCycle()


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.imgHamburger -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
            R.id.imgClose -> {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
    }

}