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

    @ColumnInfo(name = "generation")
    val generation: Int,

    @ColumnInfo(name = "ResitancesNormal")
    val resistanceNormal: Double,

    @ColumnInfo(name = "ResitancesCombat")
    val resistanceCombat: Double,

    @ColumnInfo(name = "ResitancesVol")
    val resistanceVol: Double,

    @ColumnInfo(name = "ResitancesPoison")
    val resistancePoison: Double,

    @ColumnInfo(name = "ResitancesSol")
    val resistanceSol: Double,

    @ColumnInfo(name = "ResitancesRoche")
    val resistanceRoche: Double,

    @ColumnInfo(name = "ResitancesInsecte")
    val resistanceInsecte: Double,

    @ColumnInfo(name = "ResitancesSpectre")
    val resistanceSpectre: Double,

    @ColumnInfo(name = "ResitancesAcier")
    val resistanceAcier: Double,

    @ColumnInfo(name = "ResitancesFeu")
    val resistanceFeu: Double,

    @ColumnInfo(name = "ResitancesEau")
    val resistanceEau: Double,

    @ColumnInfo(name = "ResitancesPlante")
    val resistancePlante: Double,

    @ColumnInfo(name = "ResitancesElectrik")
    val resistanceElectrik: Double,

    @ColumnInfo(name = "ResitancesPsy")
    val resistancePsy: Double,

    @ColumnInfo(name = "ResitancesGlace")
    val resistanceGlace: Double,

    @ColumnInfo(name = "ResitancesDragon")
    val resistanceDragon: Double,

    @ColumnInfo(name = "ResitancesTenebres")
    val resistanceTenebres: Double,

    @ColumnInfo(name = "ResitancesFee")
    val resistanceFee: Double,

    @ColumnInfo(name = "HP")
    val HP: Int,

    @ColumnInfo(name = "attack")
    val attack: Int,

    @ColumnInfo(name = "defense")
    val defense: Int,

    @ColumnInfo(name = "special_attack")
    val special_attack: Int,

    @ColumnInfo(name = "special_defense")
    val special_defense: Int,

    @ColumnInfo(name = "speed")
    val speed: Int,

    @ColumnInfo(name = "date_ajout")
    val date_ajout: String,

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
    val typedata: List<TypeData>,

    @Expose
    @SerializedName("apiGeneration")
    val generation: Int,

    @Expose
    @SerializedName("apiResistances")
    @Embedded
    val resistanceData: List<ResistanceData>,

    @Expose
    @SerializedName("stats")
    @Embedded
    val stats: StatsPokemon

)