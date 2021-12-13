package com.sitamadex11.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R

class HomeNoticeRecyclerAdapter:RecyclerView.Adapter<HomeNoticeRecyclerAdapter.HomeNoticeRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeNoticeRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_notice_item, parent, false)

        return HomeNoticeRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeNoticeRecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class HomeNoticeRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }
}