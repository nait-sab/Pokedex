package fr.naitflo.pokedex.pokemon.domain.usecase

import fr.naitflo.pokedex.pokemon.data.repository.PokemonRepositoryImpl
import fr.naitflo.pokedex.pokemon.domain.repository.PokemonRepository

class DeleteAllPokemonUseCase {

    private val pokemonRepository: PokemonRepository by lazy { PokemonRepositoryImpl() }

    suspend fun deleteAll() {
        pokemonRepository.deleteAll()
    }
}