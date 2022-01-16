package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.NavBaseItem
import com.gcect.gcectapp.model.NavSubItem
import com.gcect.gcectapp.model.NavSubSubItem

class MainActivityViewModel: ViewModel() {
    private val _mainList:ArrayList<NavBaseItem> = ArrayList()
    val mainList:List<NavBaseItem> = _mainList
    private val navSubItemList:ArrayList<NavSubItem?> = ArrayList()
    lateinit var subSubList:List<NavSubSubItem?>

    private  var _examScheduleYear = -1
    val examScheduleYear
    get() = _examScheduleYear

    init{
        addHomeToMainList()
        addExaminationToMainList()
        addTrainingPlacementToMainList()
        addCampusLifeToMainList()
        addTakeNoteToMainList()
    }

    private fun setSubSubItemToList(vararg navSubSubItem: NavSubSubItem?):List<NavSubSubItem?>{
        val subSubList = ArrayList<NavSubSubItem?>()
        subSubList.addAll(navSubSubItem)
        return subSubList
    }

    private fun setSubItemToList(navSubItem: NavSubItem){
        navSubItemList.add(navSubItem)
    }

    private fun setBaseItemToList(navBaseItem: NavBaseItem){
        _mainList.add(navBaseItem)
    }

    private fun  setNullToSubSubItemList():List<NavSubSubItem?>{
        val subSubList = ArrayList<NavSubSubItem?>()
        subSubList.add(null)
        return subSubList
    }

    private fun setNullToSubItemList():List<NavSubItem?>{
        val subList = ArrayList<NavSubItem?>()
        subList.add(null)
        return subList
    }

    private fun addHomeToMainList(){
        setBaseItemToList(NavBaseItem("Home",R.drawable.home_icon,setNullToSubItemList()))
        navSubItemList.clear()
    }

    private fun addExaminationToMainList(){
        subSubList = setSubSubItemToList(
            NavSubSubItem("2021-2022"),
            NavSubSubItem("2020-2021"),
            NavSubSubItem("2019-2020"))
        setSubItemToList(NavSubItem("Semester Examination Schedule",subSubList))
        subSubList = setSubSubItemToList(
            NavSubSubItem("UG Batch 2016-20, 2017-21 & PG Batch  2018-20, 2019-21"),
            NavSubSubItem("UG Batch 2015-19"),
            NavSubSubItem("UG Batch 2014-18 & PG Batch 2016-18"),
            NavSubSubItem("UG Batch 2012-16, 2013-17 & PG Batch 2012-14, 2013-15, 2014-16, 2015-17"))
        setSubItemToList(NavSubItem("Merit List",subSubList))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Examination",R.drawable.examination_icon,subList))
        navSubItemList.clear()
    }

    private fun addTrainingPlacementToMainList(){
        setSubItemToList(NavSubItem("Placement Cell",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Placement Overview",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Training & Placement",R.drawable.training_icon,subList))
        navSubItemList.clear()
    }

    private fun addCampusLifeToMainList(){
        setSubItemToList(NavSubItem("Scientific Voyage",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Workshop Seminar",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("CSI Student Chapter",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("NSS",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Students' Welfare Associations",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Campus Life",R.drawable.campus_life_icon,subList))
        navSubItemList.clear()
    }

    private fun addTakeNoteToMainList(){
        setBaseItemToList(NavBaseItem("Take Note",R.drawable.note_icon,setNullToSubItemList()))
        navSubItemList.clear()
    }

    fun setExamScheduleYear(year:Int){
        _examScheduleYear = year
    }
}