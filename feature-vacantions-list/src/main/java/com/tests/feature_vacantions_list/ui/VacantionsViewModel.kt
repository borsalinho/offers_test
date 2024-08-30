package com.tests.feature_vacantions_list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tests.feature_vacantions_list.model.VacancyFeature

class VacantionsViewModel : ViewModel() {

    private val _vacancyFeatures = MutableLiveData<List<VacancyFeature>>()
    val vacancyFeatures: LiveData<List<VacancyFeature>> get() = _vacancyFeatures


    fun setVacancyFeatures(features: List<VacancyFeature>) {
        _vacancyFeatures.value = features
    }
}