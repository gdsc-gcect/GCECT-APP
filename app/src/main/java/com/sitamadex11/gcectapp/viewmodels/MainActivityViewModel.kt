package com.sitamadex11.gcectapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sitamadex11.gcectapp.R
import com.sitamadex11.gcectapp.model.NavBaseItem
import com.sitamadex11.gcectapp.model.NavSubItem
import com.sitamadex11.gcectapp.model.NavSubSubItem

class MainActivityViewModel: ViewModel() {
    private val _mainList:ArrayList<NavBaseItem> = ArrayList()
    val mainList:List<NavBaseItem> = _mainList
    private val navSubItemList:ArrayList<NavSubItem?> = ArrayList()
    lateinit var subSubList:List<NavSubSubItem?>

    init{
        addHomeToMainList()
         addAboutUsToMainList()
       // Log.d("ListChkSP",navSubSubItemList.toString())
         addAcademicsToMainList()
        addInfrastructureToMainList()
        addExaminationToMainList()
        addTrainingPlacementToMainList()
        addCampusLifeToMainList()
        addETutorialToMainList()
        addContactUsToMainList()
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
        navSubItemList.add(null)
        return navSubItemList
    }

    private fun addHomeToMainList(){
        setBaseItemToList(NavBaseItem("Home",R.drawable.home_icon,setNullToSubItemList()))
        navSubItemList.clear()
    }

    private fun addAboutUsToMainList(){
        //setSubSubItemToList(NavSubSubItem("Administrative & Supporting Staffs"))
       // navSubSubItemList.clear()
        setSubItemToList(NavSubItem("Vision & Mission",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("History",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("The Institute",setNullToSubSubItemList()))
        subSubList = setSubSubItemToList(null,NavSubSubItem("Administrative & Supporting Staffs"))
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

    private fun addAcademicsToMainList(){
        subSubList = setSubSubItemToList(
            NavSubSubItem("Department of Ceramic Technology"),
            NavSubSubItem("Department of Information Technology"),
            NavSubSubItem("Department of Computer Science & Engg."),
            NavSubSubItem("Department of Basic Sciences Engg. & Humanities"))
        setSubItemToList(NavSubItem("Departments",subSubList))

        subSubList = setSubSubItemToList(
            NavSubSubItem("Ceramic Technology"),
            NavSubSubItem("Computer Science & Engg."),
            NavSubSubItem("Information Technology"),
            NavSubSubItem("First Year B.TECH(CSE/IT)"),
            NavSubSubItem("First Year B.TECH(CT)"))
        setSubItemToList(NavSubItem("Syllabus",subSubList))
        setSubItemToList(NavSubItem("Research & Development",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Collaboration",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Consultancy",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Academic Regulation",setNullToSubSubItemList()))

        subSubList = setSubSubItemToList(
            NavSubSubItem("Under Graduate(B.Tech)"),
            NavSubSubItem("Post Graduate(M.Tech)"),
            NavSubSubItem("CGPA to Percentage of marks certificate"))
        setSubItemToList(NavSubItem("Academic Regulation From Session 2018-19",subSubList))

        subSubList = setSubSubItemToList(
            NavSubSubItem("2021-22"),
            NavSubSubItem("2020-21"),
            NavSubSubItem("2019-20 & Earlier"))
        setSubItemToList(NavSubItem("Academic Calender",subSubList))
        setSubItemToList(NavSubItem("NIRF",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Mandatory Disclosures",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Academics",R.drawable.academics_icon,subList))
        navSubItemList.clear()
    }

    private fun addInfrastructureToMainList(){
        setSubItemToList(NavSubItem("Classroom",setNullToSubSubItemList()))

        subSubList = setSubSubItemToList(
            NavSubSubItem("Ceramic Technology"),
            NavSubSubItem("Cs & IT"),
            NavSubSubItem("Basic Science & Engg."))
        setSubItemToList(NavSubItem("Laboratories",subSubList))
        setSubItemToList(NavSubItem("Library",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Conference Room",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Auditorium",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Computer Center",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Infrastructure",R.drawable.infrastucture_icon,subList))
        navSubItemList.clear()
    }

    private fun addExaminationToMainList(){
        setSubItemToList(NavSubItem("Question Paper Download",setNullToSubSubItemList()))
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
        setSubItemToList(NavSubItem("Placement Data",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Training & Placement",R.drawable.training_icon,subList))
        navSubItemList.clear()
    }

    private fun addCampusLifeToMainList(){
        setSubItemToList(NavSubItem("Scientific Voyage",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Workshop Seminar",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("CSI Student Chapter",setNullToSubSubItemList()))

        subSubList = setSubSubItemToList(
            NavSubSubItem("Tech Club"),
            NavSubSubItem("Techtronix"))
        setSubItemToList(NavSubItem("Tech Communities",subSubList))
        setSubItemToList(NavSubItem("Cultural Fest",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("NSS",setNullToSubSubItemList()))
        setSubItemToList(NavSubItem("Students' Welfare Associations",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("Campus Life",R.drawable.campus_life_icon,subList))
        navSubItemList.clear()
    }

    private fun addETutorialToMainList(){
        setSubItemToList(NavSubItem("Downloads",setNullToSubSubItemList()))
        val subList = ArrayList<NavSubItem?>()
        subList.addAll(navSubItemList)
        setBaseItemToList(NavBaseItem("E Tutorial",R.drawable.etutorial_icon,subList))
        navSubItemList.clear()
    }

    private fun addContactUsToMainList(){
        setBaseItemToList(NavBaseItem("Contact Us",R.drawable.contact_us_icon,setNullToSubItemList()))
        navSubItemList.clear()
    }
}