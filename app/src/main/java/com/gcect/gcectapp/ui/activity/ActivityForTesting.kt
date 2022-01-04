package com.gcect.gcectapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gcect.gcectapp.R

class ActivityForTesting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_testing)
        Glide.with(this).load("http://gcect.ac.in/wp-content/uploads/2021/06/Screenshozt-2021-06-21-103815.png")
            .into(findViewById(R.id.imgChk))
    }
}