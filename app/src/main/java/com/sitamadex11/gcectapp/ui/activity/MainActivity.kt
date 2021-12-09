package com.sitamadex11.gcectapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R
import com.sitamadex11.gcectapp.adapters.NavBaseRecyclerAdapter
import com.sitamadex11.gcectapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.nav_base_recycler_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter = NavBaseRecyclerAdapter(this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        binding.imgHamburger.setOnClickListener(this)
        binding.imgClose.setOnClickListener(this)

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