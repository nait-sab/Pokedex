package fr.naitflo.pokedex.pokemon.view.mapper

import fr.naitflo.pokedex.pokemon.domain.model.PokemonPojoDomain
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI

fun List<PokemonPojoDomain>.fromDomainToRoom(): List<PokemonPojoUI> {
    return map {
        PokemonPojoUI(
            nom = it.nom,
            pokedexId = it.pokedexId,
            image = it.image,
            sprite = it.sprite,
            type1 = it.type1,
            type2 = it.type2,
            generation = it.generation,
            resistanceNormal = it.resistanceNormal,
            resistanceCombat = it.resistanceCombat,
            resistanceVol = it.resistanceVol,
            resistancePoison = it.resistancePoison,
            resistanceSol = it.resistanceSol,
            resistanceRoche = it.resistanceRoche,
            resistanceInsecte = it.resistanceInsecte,
            resistanceSpectre = it.resistanceSpectre,
            resistanceAcier = it.resistanceAcier,
            resistanceFeu = it.resistanceFeu,
            resistanceEau = it.resistanceEau,
            resistancePlante = it.resistancePlante,
            resistanceElectrik = it.resistanceElectrik,
            resistancePsy = it.resistancePsy,
            resistanceGlace = it.resistanceGlace,
            resistanceDragon = it.resistanceDragon,
            resistanceTenebres = it.resistanceTenebres,
            resistanceFee = it.resistanceFee,
            HP = it.HP,
            attack = it.attack,
            defense = it.defense,
            special_attack = it.special_attack,
            special_defense = it.special_defense,
            speed = it.speed,
            date_ajout = it.date_ajout

        )
    }
}