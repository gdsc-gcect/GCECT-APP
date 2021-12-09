package com.sitamadex11.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R

class NavBaseRecyclerAdapter(private val context: Context):RecyclerView.Adapter<NavBaseRecyclerAdapter.NavBaseRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavBaseRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_base_recycler_item, parent, false)

        return NavBaseRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavBaseRecyclerViewHolder, position: Int) {
        recyclerViewSetup(holder.navSubRecyclerView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class NavBaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navSubRecyclerView = itemView.findViewById<RecyclerView>(R.id.nav_sub_recycler_view)
    }

    private fun recyclerViewSetup(recyclerView:RecyclerView){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // Setting the Adapter with the recyclerview
        val adapter:NavSubRecyclerAdapter = NavSubRecyclerAdapter(context)
        recyclerView.adapter = adapter
    }
}