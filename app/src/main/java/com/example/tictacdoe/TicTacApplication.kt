package com.example.tictacdoe

import android.app.Application
import com.example.tictacdoe.di.repositoryModule
import com.example.tictacdoe.di.useCaseModule
import com.example.tictacdoe.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TicTacApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TicTacApplication)
            modules(listOf(repositoryModule, viewModelModule, useCaseModule))
        }
    }
}