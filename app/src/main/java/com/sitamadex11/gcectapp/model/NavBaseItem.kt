package com.sitamadex11.gcectapp.model

data class NavBaseItem(
    val title: String,
    val icon:Int,
    val navSubItemList:List<NavSubItem?>
)
