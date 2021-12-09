package com.sitamadex11.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R

class NavSubSubRecyclerAdapter:RecyclerView.Adapter<NavSubSubRecyclerAdapter.NavSubSubRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavSubSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_sub_sub_recycler_item, parent, false)

        return NavSubSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavSubSubRecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class NavSubSubRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}