package com.tests.featureemailverification.di

import com.tests.featureemailverification.emailpattern.EmailPattern
import dagger.Module
import dagger.Provides

@Module
class EmailVerificationModule {

    @Provides
    fun provideEmailPattern(): EmailPattern{
        return EmailPattern()
    }
}