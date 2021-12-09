package com.sitamadex11.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R

class NavSubRecyclerAdapter(val context: Context):RecyclerView.Adapter<NavSubRecyclerAdapter.NavSubRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_sub_recycler_item, parent, false)

        return NavSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavSubRecyclerViewHolder, position: Int) {
        recyclerViewSetup(holder.navSubSubRecyclerView)
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class NavSubRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navSubSubRecyclerView = itemView.findViewById<RecyclerView>(R.id.nav_sub_sub_recycler_view)

    }

    fun recyclerViewSetup(recyclerView:RecyclerView){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = NavSubSubRecyclerAdapter()
        // Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter
    }
}