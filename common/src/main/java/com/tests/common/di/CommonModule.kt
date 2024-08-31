package com.tests.common.di

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.s21.presentation.ui.adapters.ViewDataAdapter
import com.s21.presentation.ui.adapters.ViewDataAdapterFactory
import com.tests.common.model.ViewData
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier


@Module
class CommonModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Vacantion

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Offers
    @Provides
    fun provideViewDataAdapter(
        @Vacantion vacantion : AdapterDelegate<List<ViewData>>,
        @Offers offers : AdapterDelegate<List<ViewData>>
    ) : ViewDataAdapter {
        return ViewDataAdapterFactory.createAdapter(
            delegates = arrayOf(
                vacantion,
                offers
            )
        )
    }

}