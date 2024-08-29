package com.tests.offerstest.di

import com.tests.domain.offersrepository.OffersRepository
import com.tests.domain.usecases.GetOffersUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideGetOffersUseCase(offersRepository: OffersRepository) : GetOffersUseCase {
        return GetOffersUseCase(offersRepository = offersRepository)
    }
}