package com.izzed.ndelokmovie15

import android.app.Application
import com.izzed.ndelokmovie15.core.di.networkModule
import com.izzed.ndelokmovie15.core.di.repositoryModule
import com.izzed.ndelokmovie15.di.useCaseModule
import com.izzed.ndelokmovie15.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}