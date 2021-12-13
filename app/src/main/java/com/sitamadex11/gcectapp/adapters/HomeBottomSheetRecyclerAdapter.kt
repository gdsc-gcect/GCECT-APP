package com.sitamadex11.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R

class HomeBottomSheetRecyclerAdapter: RecyclerView.Adapter<HomeBottomSheetRecyclerAdapter.HomeBottomSheetRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeBottomSheetRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_page_bottom_sheet_list_item, parent, false)
        return HomeBottomSheetRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBottomSheetRecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class HomeBottomSheetRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }
}