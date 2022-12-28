package fr.naitflo.pokedex.pokemon.domain.repository

import androidx.lifecycle.LiveData
import fr.naitflo.pokedex.pokemon.domain.model.PokemonPojoDomain

interface  PokemonRepository {

    // Get all pokemon from database
    fun selectAll(): LiveData<List<PokemonPojoDomain>>

    // Delete all content in the table
    suspend fun deleteAll()

    // Fetch a new quote randomly and add it inside database
    suspend fun fetchData()
}