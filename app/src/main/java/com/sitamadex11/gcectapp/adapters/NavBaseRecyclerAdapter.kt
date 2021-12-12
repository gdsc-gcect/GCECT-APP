package com.sitamadex11.gcectapp.adapters

import android.content.Context
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

class NavBaseRecyclerAdapter(private val context: Context):RecyclerView.Adapter<NavBaseRecyclerAdapter.NavBaseRecyclerViewHolder>() {

    private val list = ArrayList<NavBaseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavBaseRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_base_recycler_item, parent, false)

        return NavBaseRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavBaseRecyclerViewHolder, position: Int) {
        var isClicked = true
        holder.navBaseRecyclerTitle.text = list[position].title
        holder.navBaseRecyclerIcon.setImageResource(list[position].icon)
        recyclerViewSetup(holder.navSubRecyclerView,position)
        holder.llBaseRecycler.setOnClickListener {
            if(isClicked) {
                holder.navSubRecyclerView.visibility = View.VISIBLE
                isClicked = false
            }else{
                holder.navSubRecyclerView.visibility = View.GONE
                isClicked = true
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NavBaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navBaseRecyclerTitle:TextView = itemView.findViewById(R.id.nav_base_recycler_title)
        val navBaseRecyclerIcon: ImageView = itemView.findViewById(R.id.nav_base_recycler_icon)
        val navSubRecyclerView = itemView.findViewById<RecyclerView>(R.id.nav_sub_recycler_view)
        val llBaseRecycler = itemView.findViewById<LinearLayout>(R.id.llBaseRecycler)
    }

    private fun recyclerViewSetup(recyclerView:RecyclerView,pos:Int){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // Setting the Adapter with the recyclerview
        val adapter:NavSubRecyclerAdapter = NavSubRecyclerAdapter(context)
        recyclerView.adapter = adapter
        adapter.updateList(list[pos].navSubItemList)
    }

    fun updateList(newList: List<NavBaseItem>){
        list.clear()
        list.addAll(newList)
    }
}