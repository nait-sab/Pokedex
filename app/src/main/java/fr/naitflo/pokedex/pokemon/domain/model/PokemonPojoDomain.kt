package fr.naitflo.pokedex.pokemon.domain.model

data class PokemonPojoDomain (
    val nom : String,
    val pokedexId: Int,
    val image: String,
    val sprite: String,
    val type1:String,
    val type2:String?,
):java.io.Serializable

