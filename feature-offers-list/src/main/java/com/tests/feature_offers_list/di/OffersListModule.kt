package com.tests.feature_offers_list.di

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.tests.common.di.CommonModule
import com.tests.common.model.ViewData
import com.tests.feature_offers_list.delegate.OffersAdapterDelegate
import dagger.Module
import dagger.Provides

@Module
class OffersListModule {

    @Provides
    @CommonModule.Offers
    fun provideOffersAdapterDelegate(): AdapterDelegate<List<ViewData>> {
        return OffersAdapterDelegate()
    }
}