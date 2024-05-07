package com.example.pokemonappvk.domain

import com.example.pokemonappvk.domain.modelpokeimage.ModeImagePoke
import com.example.pokemonappvk.domain.modelpokelist.ModelListPoke
import retrofit2.Response
import retrofit2.http.Path

interface PokeRepository {
    suspend fun getPokemonByName(name: String): Response<ModeImagePoke>

    suspend fun getListPoke(): Response<ModelListPoke>

    suspend fun getPokemonDetails(pokemonName: String): Response<ModeImagePoke>
}