package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.ConsultancyDetails

class ConsultancyRecyclerAdapter(
    private val context: Context,
    private val consultancyDetailList: List<ConsultancyDetails>
):
    RecyclerView.Adapter<ConsultancyRecyclerAdapter
    .ConsultancyRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ConsultancyRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.consultancy_item, parent, false)

        return ConsultancyRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder:ConsultancyRecyclerViewHolder,
        position: Int
    ) {
        holder.txtconsultancyDetail.text=consultancyDetailList[position].consultancytext


    }

    override fun getItemCount(): Int {
        return consultancyDetailList.size
    }

    inner class ConsultancyRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txtconsultancyDetail: TextView = itemView.findViewById(R.id.consultancy_item)
    }

}