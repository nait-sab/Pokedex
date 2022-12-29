package fr.naitflo.pokedex.pokemon.view.model

data class PokemonPojoUI(
    val nom : String,
    val pokedexId : Int,
    val image: String,
    val sprite: String,
    val type1:String,
    val type2:String?,
)

