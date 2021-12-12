package com.sitamadex11.gcectapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sitamadex11.gcectapp.R
import com.sitamadex11.gcectapp.model.NavBaseItem
import com.sitamadex11.gcectapp.model.NavSubItem

class NavSubRecyclerAdapter(val context: Context):RecyclerView.Adapter<NavSubRecyclerAdapter.NavSubRecyclerViewHolder>() {
    private val list = ArrayList<NavSubItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_sub_recycler_item, parent, false)

        return NavSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavSubRecyclerViewHolder, position: Int) {
        var isClicked = true
        holder.navSubRecyclerTitle.text = list[position]!!.title
        holder.navSubRecyclerIcon.setImageResource(list[position]!!.icon)
        recyclerViewSetup(holder.navSubSubRecyclerView,position)
        holder.llSubRecycler.setOnClickListener {
            if(isClicked) {
                holder.navSubSubRecyclerView.visibility = View.VISIBLE
                if(list[position]?.navSubSubItemList!!.size > 1)
                holder.navSubRecyclerIcon.setImageResource(R.drawable.open_hand_icon)
                isClicked = false
            }else{
                holder.navSubSubRecyclerView.visibility = View.GONE
                if(list[position]?.navSubSubItemList!!.size > 1)
                    holder.navSubRecyclerIcon.setImageResource(R.drawable.close_hand_icon)
                isClicked = true
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NavSubRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navSubRecyclerTitle: TextView = itemView.findViewById(R.id.nav_sub_recycler_title)
        val navSubRecyclerIcon: ImageView = itemView.findViewById(R.id.nav_sub_recycler_icon)
        val navSubSubRecyclerView = itemView.findViewById<RecyclerView>(R.id.nav_sub_sub_recycler_view)
        val llSubRecycler = itemView.findViewById<LinearLayout>(R.id.llSubRecycler)

    }

    fun recyclerViewSetup(recyclerView:RecyclerView,position: Int){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = NavSubSubRecyclerAdapter()
        // Setting the Adapter with the recyclerview
        adapter.updateList(list[position]!!.navSubSubItemList)
        recyclerView.adapter = adapter
    }

    fun updateList(newList: List<NavSubItem?>){
        list.clear()
        list.addAll(newList)
    }
}