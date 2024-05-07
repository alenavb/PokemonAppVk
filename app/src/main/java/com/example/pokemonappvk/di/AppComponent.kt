package com.example.pokemonappvk.di

import android.app.Application
import com.example.pokemonappvk.presentation.MainActivity
import com.example.pokemonappvk.presentation.details.DetailsFragment
import com.example.pokemonappvk.presentation.main.MainFragment
import com.example.pokemonappvk.presentation.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppBindsModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
    fun inject(detailsFragment: DetailsFragment)
    fun mainViewModel(): MainViewModel.Factory
}