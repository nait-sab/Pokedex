package fr.naitflo.pokedex.pokemon.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResistanceData(
    @Expose
    @SerializedName("name")
    var name: String,

    @Expose
    @SerializedName("damage_multiplier")
    var damage_multiplier: Double,

    @Expose
    @SerializedName("damage_relation")
    var damage_relation: String,
)

