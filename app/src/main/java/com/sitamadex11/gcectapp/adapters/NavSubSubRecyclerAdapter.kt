package com.sitamadex11.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R
import com.sitamadex11.gcectapp.model.NavSubItem
import com.sitamadex11.gcectapp.model.NavSubSubItem

class NavSubSubRecyclerAdapter:RecyclerView.Adapter<NavSubSubRecyclerAdapter.NavSubSubRecyclerViewHolder>() {

    private val list = ArrayList<NavSubSubItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavSubSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_sub_sub_recycler_item, parent, false)

        return NavSubSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavSubSubRecyclerViewHolder, position: Int) {
        if(list[position] != null) {
            holder.navSubSubRecyclerTitle.text = list[position]!!.title
            holder.navSubSubRecyclerIcon.setImageResource(list[position]!!.icon)
            holder.llSubSub.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NavSubSubRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navSubSubRecyclerTitle: TextView = itemView.findViewById(R.id.nav_sub_sub_recycler_title)
        val navSubSubRecyclerIcon: ImageView = itemView.findViewById(R.id.nav_sub_sub_recycler_icon)
        val llSubSub: LinearLayout = itemView.findViewById(R.id.llSubSub)
    }

    fun updateList(newList: List<NavSubSubItem?>){
        list.clear()
        list.addAll(newList)
    }
}