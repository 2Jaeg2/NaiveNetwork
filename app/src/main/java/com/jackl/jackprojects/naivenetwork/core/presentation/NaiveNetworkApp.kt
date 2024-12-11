package com.jackl.jackprojects.naivenetwork.core.presentation

import android.app.Application
import com.jackl.jackprojects.naivenetwork.auth.presentation.di.authPresentationViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NaiveNetworkApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NaiveNetworkApp)
            modules(
                authPresentationViewModelModule
            )
        }
    }
}