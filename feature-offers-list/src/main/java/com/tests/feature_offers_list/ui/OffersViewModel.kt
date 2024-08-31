package com.tests.feature_offers_list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tests.feature_offers_list.model.OfferFeature

class OffersViewModel : ViewModel() {
    private val _offersFeatures = MutableLiveData<List<OfferFeature>>()
    val offersFeatures: LiveData<List<OfferFeature>> = _offersFeatures



    fun setVacancyFeatures(offers: List<OfferFeature>) {
        _offersFeatures.value = offers
    }
}