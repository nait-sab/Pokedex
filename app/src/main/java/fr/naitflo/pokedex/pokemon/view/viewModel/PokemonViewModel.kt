package fr.naitflo.pokedex.pokemon.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import fr.naitflo.pokedex.pokemon.domain.usecase.DeleteAllPokemonUseCase
import fr.naitflo.pokedex.pokemon.domain.usecase.FetchNewPokemonUseCase
import fr.naitflo.pokedex.pokemon.domain.usecase.GetPokemonUseCase
import fr.naitflo.pokedex.pokemon.view.mapper.fromDomainToRoom
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val getPokemonUseCase: GetPokemonUseCase by lazy { GetPokemonUseCase() }
    private val fetchNewPokemonUseCase: FetchNewPokemonUseCase by lazy { FetchNewPokemonUseCase() }
    private val deleteAllPokemonUseCase: DeleteAllPokemonUseCase by lazy { DeleteAllPokemonUseCase() }

    var pokemonLiveData: LiveData<List<PokemonPojoUI>> =
        getPokemonUseCase.selectAll().map {
            it.fromDomainToRoom()
        }

    fun fetchNewPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchNewPokemonUseCase.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllPokemonUseCase.deleteAll()
        }
    }

}