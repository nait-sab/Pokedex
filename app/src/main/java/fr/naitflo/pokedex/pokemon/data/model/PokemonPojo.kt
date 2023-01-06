package fr.naitflo.pokedex.pokemon.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

///TODO:Ajouter les stats et résistances
/** Object use for room */
@Entity(tableName = "pokemon")
data class PokemonRoom(
    @ColumnInfo(name = "nom")
    val nom: String,

    @ColumnInfo(name = "pokedexId")
    val pokedexId: Int,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "sprite")
    val sprite: String,

    @ColumnInfo(name = "type1")
    val type1: String,

    @ColumnInfo(name = "type2")
    val type2: String?,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class PokemonRetrofit(
    @Expose
    @SerializedName("name")
    val nom: String,

    @Expose
    @SerializedName("pokedexId")
    val pokedexId: Int,

    @Expose
    @SerializedName("image")
    val image: String,

    @Expose
    @SerializedName("sprite")
    val sprite: String,

    @Expose
    @SerializedName("apiTypes")
    @Embedded
    val typedata: List<TypeData>

)