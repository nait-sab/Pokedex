package fr.naitflo.pokedex.pokemon.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import fr.naitflo.pokedex.architecture.App
import fr.naitflo.pokedex.architecture.RetrofitBuilder
import fr.naitflo.pokedex.pokemon.data.mapper.fromRoomToDomain
import fr.naitflo.pokedex.pokemon.data.mapper.toRoom
import fr.naitflo.pokedex.pokemon.data.model.PokemonRoom
import fr.naitflo.pokedex.pokemon.domain.model.PokemonPojoDomain
import fr.naitflo.pokedex.pokemon.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

class PokemonRepositoryImpl : PokemonRepository {
    private val mPokemonDao = App.instance.appDatabase.pokemonDao()

    private suspend fun insertPokemon(pokemonRoom: PokemonRoom) =
        withContext(Dispatchers.IO) {
            mPokemonDao.insert(pokemonRoom)
        }


    override fun selectAll(): LiveData<List<PokemonPojoDomain>> {
        return mPokemonDao.selectAll().map { list ->
            list.fromRoomToDomain()
        }
    }

    override suspend fun deleteAll()  = withContext(Dispatchers.IO) {
        mPokemonDao.deleteAll()
    }

    override suspend fun fetchData() {
        val rdmpkm = Random.nextInt(0, 898)
        insertPokemon(RetrofitBuilder.pokemon().getRandomPokemon(rdmpkm).toRoom())

    }

}