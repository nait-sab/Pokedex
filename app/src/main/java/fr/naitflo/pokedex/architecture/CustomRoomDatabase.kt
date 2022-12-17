package fr.naitflo.pokedex.architecture

import androidx.room.Database
import androidx.room.RoomDatabase

// Here goes the configuration of all entities needed
@Database(
    entities = [
        PokemonRoom::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    // Here goes the list of all DAO needed
    abstract fun pokemonDao(): PokemonDao
}