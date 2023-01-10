package fr.naitflo.pokedex.pokemon.domain.usecase

import fr.naitflo.pokedex.pokemon.data.repository.PokemonRepositoryImpl
import fr.naitflo.pokedex.pokemon.domain.repository.PokemonRepository

class FetchNewPokemonUseCase {
    private val pokemonRepository: PokemonRepository by lazy { PokemonRepositoryImpl() }

    suspend fun fetchData() {
        pokemonRepository.fetchData()
    }
}