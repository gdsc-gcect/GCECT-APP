package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.gcect.gcectapp.R
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(var images: IntArray) : SliderViewAdapter<SliderAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(viewHolder: Holder, position: Int) {
        viewHolder.imageView.setImageResource(images[position])
    }

    override fun getCount(): Int {
        return images.size
    }

    inner class Holder(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.slider_image_view)

    }
}