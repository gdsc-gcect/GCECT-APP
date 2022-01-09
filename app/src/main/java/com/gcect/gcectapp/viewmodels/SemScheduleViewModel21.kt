package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.DownloadViewListModel
import com.gcect.gcectapp.utils.SemScheduleViewModelCallBack

class SemScheduleViewModel21:ViewModel(), SemScheduleViewModelCallBack {
    private val _evenSemList = ArrayList<DownloadViewListModel>()
    val evenSemList
        get() = _evenSemList

    private val _oddSemList = ArrayList<DownloadViewListModel>()
    val oddSemList
        get() = _oddSemList

    private var _listPos = -1
    val listPos
        get() = _listPos

    private var _isEvenList = true
    val isEvenList
        get() = _isEvenList

    private var _navFragId = -1
    val navFragId
        get() = _navFragId

    init {
        addDataToEvenSemList()
        addDataToOddSemList()
    }
    private fun addDataToEvenSemList(){
        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/Student'%20Welfare%20Association.pdf?alt=media&token=7702cb77-2b10-42e2-b5b9-2b06c563dbaf")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )
    }

    private fun addDataToOddSemList(){
        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=15622a54-4811-4585-be49-b931ba441112")
        )
    }

    override fun setListPosAndType(pos:Int,isEven:Boolean){
        _listPos = pos
        _isEvenList = isEven
    }

    override fun setNavFragId(id:Int){
        _navFragId = id
    }
    fun getList(isEven:Boolean):List<DownloadViewListModel>{
        return if(isEven) evenSemList else oddSemList
    }
}