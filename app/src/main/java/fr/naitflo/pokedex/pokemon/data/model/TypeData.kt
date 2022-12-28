package fr.naitflo.pokedex.pokemon.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TypeData (
    @Expose
    @SerializedName("name")
    var name: String,

    @Expose
    @SerializedName("image")
    var image: String,
    )

