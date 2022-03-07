package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.ConsultancyDetails

class ConsultancyViewmodel:ViewModel() {

        private val _listOfConsultancyDetail = ArrayList<ConsultancyDetails>()
        val listOfConsultancyDetail:List<ConsultancyDetails> = _listOfConsultancyDetail

        init {
            addCollaborationDetailToList("Consultancy activities are carried out by faculty members of various departments. They are provided to different organizations by way of auditing and as technical experts during audit of ISO 9001:2008 QMS, ISO 14001:2004 Ems and ISO 18001:2007 OHSAS.")
        }

        private fun addCollaborationDetailToList(detail: String) {
            val collaborationDetail = ConsultancyDetails(detail)
            _listOfConsultancyDetail.add(collaborationDetail)
        }

    }
