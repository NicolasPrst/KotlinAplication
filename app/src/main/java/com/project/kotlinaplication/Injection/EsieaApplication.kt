package com.project.kotlinaplication.Injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EsieaApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@EsieaApplication)
            modules(appModule, domainModule, dataModule)
        }
    }
}