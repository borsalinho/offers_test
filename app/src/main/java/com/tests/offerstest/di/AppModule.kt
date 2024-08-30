package com.tests.offerstest.di

import android.content.Context
import com.tests.domain.usecases.GetOffersUseCase
import com.tests.offerstest.ui.fragments.search.SearchViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context
) {

    @Provides
    @Singleton
    fun provideContext() : Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSearchViewModel(
        getOffersUseCase: GetOffersUseCase
    ) : SearchViewModel {
        return SearchViewModel(
            getOffersUseCase = getOffersUseCase
        )
    }
}