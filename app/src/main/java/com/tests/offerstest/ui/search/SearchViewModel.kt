package com.tests.offerstest.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tests.domain.usecases.GetOffersUseCase
import com.tests.offerstest.mappers.toOffersViewData
import com.tests.offerstest.models.OffersViewData
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModel() {

    private val _offers = MutableLiveData<OffersViewData>()
    private val offers: LiveData<OffersViewData> get() = _offers

    fun fetchOffers() {
        viewModelScope.launch {
            try {
                System.out.println("1")
                val result = getOffersUseCase.execute().toOffersViewData()
                System.out.println("2")
                _offers.value = result
                System.out.println("3")
                System.out.println(offers.value.toString())
            } catch (e: Exception) {
                System.out.println("Failed to parse JSON data: ${e.message}")
                System.out.println("НИХУЯ")
            }
        }
    }
}