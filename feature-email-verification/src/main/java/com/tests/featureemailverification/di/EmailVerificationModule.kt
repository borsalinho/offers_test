package com.tests.featureemailverification.di

import dagger.Module
import dagger.Provides

@Module
class EmailVerificationModule {

    @Provides
    fun provideEmailPattern(): String = ".*@mail\\.ru"
}