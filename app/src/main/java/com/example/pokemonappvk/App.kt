package com.example.pokemonappvk

import android.app.Application
import com.example.pokemonappvk.di.AppComponent
import com.example.pokemonappvk.di.DaggerAppComponent

open class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}