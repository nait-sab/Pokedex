package fr.naitflo.pokedex.pokemon.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.naitflo.pokedex.pokemon.data.model.PokemonRoom

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun selectAll(): LiveData<List<PokemonRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemonRoom: PokemonRoom)

    @Query("DELETE FROM pokemon")
    fun deleteAll()
}