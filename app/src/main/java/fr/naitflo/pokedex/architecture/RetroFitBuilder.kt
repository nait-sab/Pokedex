package fr.naitflo.pokedex.architecture

import com.google.gson.GsonBuilder
import fr.naitflo.pokedex.pokemon.data.remote.PokemonEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokebuildapi.fr/api/v1/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun pokemonQuote(): PokemonEndpoint =
        retrofit.create(PokemonEndpoint::class.java)
}