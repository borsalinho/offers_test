package com.tests.offerstest.app

import android.app.Application
import com.tests.common.di.CommonModule
import com.tests.feature_offers_list.di.OffersListModule
import com.tests.feature_vacantions_list.di.VacantionsListModule
import com.tests.featureemailverification.di.EmailVerificationModule
import com.tests.offerstest.di.AppComponent
import com.tests.offerstest.di.AppModule
import com.tests.offerstest.di.DaggerAppComponent
import com.tests.offerstest.di.DataModule
import com.tests.offerstest.di.DomainModule


class MyApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .domainModule(DomainModule())
            .commonModule(CommonModule())
            .emailVerificationModule(EmailVerificationModule())
            .vacantionsListModule(VacantionsListModule())
            .offersListModule(OffersListModule())
            .build()
    }
}