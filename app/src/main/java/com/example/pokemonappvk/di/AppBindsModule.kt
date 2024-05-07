package com.example.pokemonappvk.di

import com.example.pokemonappvk.data.repository.PokeRepositoryImpl
import com.example.pokemonappvk.domain.PokeRepository
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindProductRepository(repositoryImp: PokeRepositoryImpl): PokeRepository
}