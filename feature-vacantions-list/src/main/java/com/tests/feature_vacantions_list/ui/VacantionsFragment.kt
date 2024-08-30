package com.tests.feature_vacantions_list.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tests.feature_vacantions_list.model.VacancyFeature

class VacantionsFragment(
    private val vacancyFeatures: List<VacancyFeature>
) : Fragment() {

    private val vacantionsViewModel: VacantionsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vacantionsViewModel.setVacancyFeatures(vacancyFeatures)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacantionsViewModel.vacancyFeatures.observe(viewLifecycleOwner, Observer { features ->
            features?.forEach { vacancyFeature ->
                println(vacancyFeature)
            }
        })
    }
}