package com.tests.feature_vacantions_list.ui.vacantionsdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tests.feature_vacantions_list.model.VacancyFeature

class VacantionsDetailViewModel : ViewModel() {

    private val _vacancyFeature = MutableLiveData<VacancyFeature>()
    val vacancyFeature: LiveData<VacancyFeature> = _vacancyFeature

    fun setVacancyFeature(vacancyFeature : VacancyFeature){
        _vacancyFeature.value = vacancyFeature
    }

}