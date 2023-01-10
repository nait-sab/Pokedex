package fr.naitflo.pokedex.pokemon.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StatsPokemon(
    @Expose
    @SerializedName("HP")
    var hp: Int,

    @Expose
    @SerializedName("attack")
    var attack: Int,

    @Expose
    @SerializedName("defense")
    var defense: Int,

    @Expose
    @SerializedName("special_attack")
    var special_attack: Int,

    @Expose
    @SerializedName("special_defense")
    var special_defense: Int,

    @Expose
    @SerializedName("speed")
    var speed: Int,
)