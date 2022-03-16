package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.FacultyAdapter
import com.gcect.gcectapp.databinding.FragmentDepartmentCTBinding
import com.gcect.gcectapp.model.FacultyModel

class DepartmentCTFragment : Fragment() {

    private lateinit var binding: FragmentDepartmentCTBinding
    private lateinit var facultyMembersRecyclerView: RecyclerView
    private lateinit var facultyList: ArrayList<FacultyModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_department_c_t, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ctFragment = this

        facultyMembersRecyclerView = binding.facultyMembersRv
        facultyMembersRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        facultyList = ArrayList()
        facultyList = setFacultysData()
        facultyMembersRecyclerView.adapter = FacultyAdapter(
            requireContext(),
            facultyList as MutableList<FacultyModel>
        )
    }

    private fun setFacultysData() : ArrayList<FacultyModel>{
        var arrayList:ArrayList<FacultyModel> = ArrayList()

        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))
        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))
        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))
        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))

        return arrayList
    }

}