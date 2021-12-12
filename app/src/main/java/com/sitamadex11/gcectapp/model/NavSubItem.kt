package com.sitamadex11.gcectapp.model

import com.sitamadex11.gcectapp.R

data class NavSubItem(
    val title: String,
    val navSubSubItemList:List<NavSubSubItem?>,
    val icon:Int = R.drawable.close_hand_icon
)
