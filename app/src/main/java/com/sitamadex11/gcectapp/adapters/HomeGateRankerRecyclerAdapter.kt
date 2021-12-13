package com.sitamadex11.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R

class HomeGateRankerRecyclerAdapter:RecyclerView.Adapter<HomeGateRankerRecyclerAdapter.HomeGateRankerRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeGateRankerRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_gate_ranker_item, parent, false)
        return HomeGateRankerRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeGateRankerRecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class HomeGateRankerRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }
}