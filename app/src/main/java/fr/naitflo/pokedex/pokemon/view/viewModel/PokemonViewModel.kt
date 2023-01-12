package fr.naitflo.pokedex.pokemon.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import fr.naitflo.pokedex.pokemon.domain.usecase.DeleteAllPokemonUseCase
import fr.naitflo.pokedex.pokemon.domain.usecase.FetchNewPokemonUseCase
import fr.naitflo.pokedex.pokemon.domain.usecase.GetPokemonUseCase
import fr.naitflo.pokedex.pokemon.view.mapper.fromDomainToRoom
import fr.naitflo.pokedex.pokemon.view.model.MyPokemonForRecyclerView
import fr.naitflo.pokedex.pokemon.view.model.PokemonHeader
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val getPokemonUseCase: GetPokemonUseCase by lazy { GetPokemonUseCase() }
    private val fetchNewPokemonUseCase: FetchNewPokemonUseCase by lazy { FetchNewPokemonUseCase() }
    private val deleteAllPokemonUseCase: DeleteAllPokemonUseCase by lazy { DeleteAllPokemonUseCase() }

    var pokemonLiveData: LiveData<List<MyPokemonForRecyclerView>> =
        getPokemonUseCase.selectAll().map { list ->
            list.fromDomainToRoom().toMyPokemonForRecyclerView()
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


    private fun List<PokemonPojoUI>.toMyPokemonForRecyclerView(): List<MyPokemonForRecyclerView> {

        val result = mutableListOf<MyPokemonForRecyclerView>()

        groupBy {
            it.generation
        }.forEach { (generation, items) ->

            result.add(PokemonHeader(generation.toString()))
            result.addAll(items)

        }
        return result
    }


}


