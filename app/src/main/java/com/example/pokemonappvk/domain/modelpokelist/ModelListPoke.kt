package com.example.pokemonappvk.domain.modelpokelist

data class ModelListPoke(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)