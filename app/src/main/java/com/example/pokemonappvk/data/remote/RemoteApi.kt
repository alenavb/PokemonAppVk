package com.example.pokemonappvk.data.remote

import com.example.pokemonappvk.domain.modelpokeimage.ModeImagelPoke
import com.example.pokemonappvk.domain.modelpokelist.ModelListPoke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {
    @GET("pokemon/{name}/")
    suspend fun getPokemonByName(@Path("name") name: String): Response<ModeImagelPoke>

    @GET("pokemon?limit=300&offset=0")
    suspend fun getListPoke(): Response<ModelListPoke>
}
