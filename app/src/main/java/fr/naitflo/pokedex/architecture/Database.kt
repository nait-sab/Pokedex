package fr.naitflo.pokedex.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.naitflo.pokedex.pokemon.data.dao.PokemonDao
import fr.naitflo.pokedex.pokemon.data.model.PokemonPojo

//@Database(
//    entities = [
//    ],
//    version = 2,
//    exportSchema = false
//)
//abstract class Database : RoomDatabase() {
//    abstract fun pokemonDao(): PokemonDao
//}