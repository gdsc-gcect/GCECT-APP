package com.sitamadex11.gcectapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sitamadex11.gcectapp.R
import com.sitamadex11.gcectapp.model.NavBaseItem
import com.sitamadex11.gcectapp.model.NavSubItem
import com.sitamadex11.gcectapp.model.NavSubSubItem

class MainActivityViewModel: ViewModel() {
    val mainList:ArrayList<NavBaseItem> = ArrayList()
    val navSubItemList:ArrayList<NavSubItem?> = ArrayList()
    val navSubSubItemList:ArrayList<NavSubSubItem?> = ArrayList()

    init{
         addAboutUsToMainList()
        Log.d("ListChkSP",navSubSubItemList.toString())
    }

    fun setSubSubItemToList(vararg navSubSubItem: NavSubSubItem?):List<NavSubSubItem?>{
        val subSubList = ArrayList<NavSubSubItem?>()
        subSubList.addAll(navSubSubItem)
        return subSubList
    }

    fun setSubItemToList(navSubItem: NavSubItem){
        navSubItemList.add(navSubItem)
    }

    fun setBaseItemToList(navBaseItem: NavBaseItem){
        mainList.add(navBaseItem)
    }

    fun  setNullToSubSubItemList():ArrayList<NavSubSubItem?>{
        val subSubList = ArrayList<NavSubSubItem?>()
        subSubList.add(null)
        return subSubList
    }

    fun addAboutUsToMainList(){
        //setSubSubItemToList(NavSubSubItem("Administrative & Supporting Staffs"))
        navSubSubItemList.clear()
        setSubItemToList(NavSubItem("Vision & Mission",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("History",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("The Institute",setNullToSubSubItemList()))
        val subSubList = setSubSubItemToList(null,NavSubSubItem("Administrative & Supporting Staffs"))
        setSubItemToList(NavSubItem("Administration",subSubList))
        setSubItemToList(NavSubItem("Annual Report",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("IQAC",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Right to Information Act",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Anti Ragging Cell",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Gallery",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("About Us",R.drawable.about_us_icon,subList))
        navSubItemList.clear()
    }

}