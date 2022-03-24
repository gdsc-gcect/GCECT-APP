package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.FacultyModel

class FacultyAdapter(private val contxt: Context, private val facultyList: MutableList<FacultyModel>) : RecyclerView.Adapter<FacultyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.faculty_member_item_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val faculty = facultyList[position]
        holder.itemView.apply {
            faculty.facultyImage?.let { holder.facultyImage.setImageResource(it) }
            holder.facultyName.text = faculty.facultyName
            holder.facultyRole.text = faculty.facultyRole
        }
    }

    override fun getItemCount(): Int {
        return facultyList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val facultyImage : ImageView = itemView.findViewById(R.id.faculty_image)
        val facultyName : TextView = itemView.findViewById(R.id.faculty_name)
        val facultyRole : TextView = itemView.findViewById(R.id.faculty_role)
    }
}