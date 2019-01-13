package com.vitaliimalone.nicenewskotlin

import android.app.Application
import com.vitaliimalone.nicenewskotlin.di.appModule
import org.koin.android.ext.android.startKoin

class NiceNewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModule)
    }
}