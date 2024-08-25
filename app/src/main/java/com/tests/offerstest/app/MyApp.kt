package com.tests.offerstest.app

import android.app.Application
import com.tests.offerstest.di.AppComponent
import com.tests.offerstest.di.AppModule
import com.tests.offerstest.di.DaggerAppComponent
import dagger.Component
import javax.inject.Singleton

class MyApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}