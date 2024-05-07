package com.example.pokemonappvk.data.repository

import com.example.pokemonappvk.data.remote.RemoteApi
import com.example.pokemonappvk.domain.PokeRepository
import com.example.pokemonappvk.domain.modelpokeimage.ModeImagePoke
import com.example.pokemonappvk.domain.modelpokelist.ModelListPoke
import retrofit2.Response
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(private val api: RemoteApi) : PokeRepository {
    override suspend fun getPokemonByName(name: String): Response<ModeImagePoke> {
        return api.getPokemonByName(name)
    }

    override suspend fun getListPoke(): Response<ModelListPoke> {
        return api.getListPoke()
    }

    override suspend fun getPokemonDetails(pokemonName: String): Response<ModeImagePoke> {
        return api.getPokemonDetails(pokemonName)
    }
}