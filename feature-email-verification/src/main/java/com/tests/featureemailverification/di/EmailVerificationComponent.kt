package com.tests.featureemailverification.di

import com.tests.featureemailverification.ui.EmailVerificationFragment
import dagger.Subcomponent


@Subcomponent(
    modules = [
        EmailVerificationModule::class
    ]
)
interface EmailVerificationComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create() : EmailVerificationComponent
    }

    fun inject(fragment : EmailVerificationFragment)
}