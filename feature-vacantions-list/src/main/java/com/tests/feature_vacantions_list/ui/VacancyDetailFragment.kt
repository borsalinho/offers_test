package com.tests.feature_vacantions_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tests.feature_vacantions_list.R

class VacancyDetailFragment : Fragment() {

    private val vacantionsViewModel: VacantionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val vacancyId = it.getString("id_key")
            if (vacancyId != null) {
                vacantionsViewModel.selectVacancy(vacancyId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vacancy_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vacantionsViewModel.selectedVacancyId.observe(viewLifecycleOwner, Observer { id ->
            println(id)
        })
    }
}
