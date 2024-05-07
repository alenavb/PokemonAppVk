package com.example.pokemonappvk.data.remote

import com.example.pokemonappvk.domain.modelpokeimage.ModeImagePoke
import com.example.pokemonappvk.domain.modelpokelist.ModelListPoke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {
    @GET("pokemon/{name}/")
    suspend fun getPokemonByName(@Path("name") name: String): Response<ModeImagePoke>

    @GET("pokemon/{name}/")
    suspend fun getPokemonDetails(@Path("name") pokemonName: String): Response<ModeImagePoke>


    @GET("pokemon?limit=300&offset=0")
    suspend fun getListPoke(): Response<ModelListPoke>
}
