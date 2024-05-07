package com.example.pokemonappvk.domain

import com.example.pokemonappvk.domain.modelpokeimage.ModeImagelPoke
import com.example.pokemonappvk.domain.modelpokelist.ModelListPoke
import retrofit2.Response

interface PokeRepository {
    suspend fun getPokemonByName(name: String): Response<ModeImagelPoke>

    suspend fun getListPoke(): Response<ModelListPoke>
}