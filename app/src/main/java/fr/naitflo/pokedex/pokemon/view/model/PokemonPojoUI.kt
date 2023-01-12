package fr.naitflo.pokedex.pokemon.view.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



sealed class MyPokemonForRecyclerView()

data class PokemonHeader(
    val header: String
) : MyPokemonForRecyclerView()

@Parcelize
data class PokemonPojoUI(
    val nom: String?,
    val pokedexId: Int,
    val image: String?,
    val sprite: String?,
    val type1: String?,
    val type2: String?,
    val generation: Int,
    val resistanceNormal: Double,
    val resistanceCombat: Double,
    val resistanceVol: Double,
    val resistancePoison: Double,
    val resistanceSol: Double,
    val resistanceRoche: Double,
    val resistanceInsecte: Double,
    val resistanceSpectre: Double,
    val resistanceAcier: Double,
    val resistanceFeu: Double,
    val resistanceEau: Double,
    val resistancePlante: Double,
    val resistanceElectrik: Double,
    val resistancePsy: Double,
    val resistanceGlace: Double,
    val resistanceDragon: Double,
    val resistanceTenebres: Double,
    val resistanceFee: Double,
    val HP: Int,
    val attack: Int,
    val defense: Int,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int,
    val date_ajout: String?,
):MyPokemonForRecyclerView(), Parcelable



data class PokemonFooter(
    val footer: String
) : MyPokemonForRecyclerView()