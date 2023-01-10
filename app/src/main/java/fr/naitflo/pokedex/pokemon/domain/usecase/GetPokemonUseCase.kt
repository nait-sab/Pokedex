package fr.naitflo.pokedex.pokemon.domain.usecase

import androidx.lifecycle.LiveData
import fr.naitflo.pokedex.pokemon.data.repository.PokemonRepositoryImpl
import fr.naitflo.pokedex.pokemon.domain.model.PokemonPojoDomain
import fr.naitflo.pokedex.pokemon.domain.repository.PokemonRepository

class GetPokemonUseCase {
    private val pokemonRepository: PokemonRepository by lazy { PokemonRepositoryImpl() }


    fun selectAll(): LiveData<List<PokemonPojoDomain>> {
        return pokemonRepository.selectAll()
    }
}