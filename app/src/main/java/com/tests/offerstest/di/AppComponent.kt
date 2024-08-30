package com.tests.offerstest.di

import com.tests.common.di.CommonModule
import com.tests.feature_vacantions_list.di.VacantionsListModule
import com.tests.featureemailverification.di.EmailVerificationModule
import com.tests.offerstest.ui.fragments.entry.EntryFragment
import com.tests.offerstest.ui.fragments.search.SearchFragment
import com.tests.offerstest.ui.fragments.verification.VerificationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class,
        EmailVerificationModule::class,
        CommonModule::class,
        VacantionsListModule::class
    ]
)
interface AppComponent {
    fun inject(entryFragment: EntryFragment)
    fun inject(verificationFragment: VerificationFragment)

    fun inject(searchFragment : SearchFragment)

}