package com.tests.offerstest.di

import com.tests.featureemailverification.di.EmailVerificationModule
import com.tests.offerstest.ui.entry.EntryFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        EmailVerificationModule::class
    ]
)
interface AppComponent {
    fun inject(entryFragment: EntryFragment)

}