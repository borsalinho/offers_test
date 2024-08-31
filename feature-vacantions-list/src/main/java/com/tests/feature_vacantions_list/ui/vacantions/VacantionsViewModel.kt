package com.tests.feature_vacantions_list.ui.vacantions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tests.feature_vacantions_list.model.VacancyFeature
import kotlinx.coroutines.launch

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
        _selectedVacancyId.value = id
    }

    fun selectVacancy() {
        viewModelScope.launch {
            _vacancyFeatures.value?.let { features ->
                _selectedVacancy.value = features.find { it.id == selectedVacancyId.value }
            }
        }
    }
}
