package com.tests.feature_vacantions_list.di

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.tests.common.di.CommonModule
import com.tests.common.model.ViewData
import com.tests.feature_vacantions_list.delegate.VacationsAdapterDelegate
import com.tests.feature_vacantions_list.ui.vacantions.VacantionsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VacantionsListModule {
    @Provides
    @CommonModule.Vacantion
    fun provideVacationsAdapterDelegate(): AdapterDelegate<List<ViewData>> {
        return VacationsAdapterDelegate()
    }
}