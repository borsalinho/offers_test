package com.tests.feature_vacantions_list.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tests.feature_vacantions_list.model.VacancyFeature

class VacantionsViewModel : ViewModel() {

    private val _vacancyFeatures = MutableLiveData<List<VacancyFeature>>()
    val vacancyFeatures: LiveData<List<VacancyFeature>> = _vacancyFeatures

    private val _selectedVacancy = MutableLiveData<VacancyFeature?>()
    val selectedVacancy: LiveData<VacancyFeature?> = _selectedVacancy

    private val _selectedVacancyId = MutableLiveData<String?>()
    val selectedVacancyId: LiveData<String?> = _selectedVacancyId

    fun setVacancyFeatures(features: List<VacancyFeature>) {
        _vacancyFeatures.value = features
    }

    fun setSelectedVacancyId(id: String) {
        Log.d("VacancyDetailFragment", "сохраняю ключ вьюмодель  ${id}")
        _selectedVacancyId.value = id
        Log.d("VacancyDetailFragment", "после осхранения  ${selectedVacancyId.value}")
    }

    fun selectVacancy(vacancyId: String) {
        Log.d("VacancyDetailFragment", "буду искать")
        _vacancyFeatures.value?.let { features ->
            Log.d("VacancyDetailFragment", "ищу")
            _selectedVacancy.value = features.find { it.id == vacancyId }
            Log.d("VacancyDetailFragment", "нашел ${selectedVacancy.value}")
        }
    }
}
