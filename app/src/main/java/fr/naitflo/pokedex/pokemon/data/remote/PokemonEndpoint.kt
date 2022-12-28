package fr.naitflo.pokedex.pokemon.data.remote

import fr.naitflo.pokedex.pokemon.data.model.PokemonRetrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonEndpoint {
    //Permet d'avoir un pokémon aléatoirement avec son id
    @GET("pokemon/{id}")
    suspend fun getRandomPokemon(@Path("id") id: Int?) : PokemonRetrofit
}