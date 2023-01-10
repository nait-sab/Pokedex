package fr.naitflo.pokedex.pokemon.data.mapper

import fr.naitflo.pokedex.pokemon.data.model.PokemonRetrofit
import fr.naitflo.pokedex.pokemon.data.model.PokemonRoom
import fr.naitflo.pokedex.pokemon.domain.model.PokemonPojoDomain
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun PokemonRetrofit.toRoom(): PokemonRoom {
    val current = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    val formatted = current.format(formatter)
    return PokemonRoom(
        nom = nom,
        pokedexId = pokedexId,
        image = image,
        sprite = sprite,
        type1 = typedata[0].image,
        type2 = if (typedata.size > 1) typedata[1].image else null,
        generation = generation,
        resistanceNormal = resistanceData[0].damage_multiplier,
        resistanceCombat = resistanceData[1].damage_multiplier,
        resistanceVol = resistanceData[2].damage_multiplier,
        resistancePoison = resistanceData[3].damage_multiplier,
        resistanceSol = resistanceData[4].damage_multiplier,
        resistanceRoche = resistanceData[5].damage_multiplier,
        resistanceInsecte = resistanceData[6].damage_multiplier,
        resistanceSpectre = resistanceData[7].damage_multiplier,
        resistanceAcier = resistanceData[8].damage_multiplier,
        resistanceFeu = resistanceData[9].damage_multiplier,
        resistanceEau = resistanceData[10].damage_multiplier,
        resistancePlante = resistanceData[11].damage_multiplier,
        resistanceElectrik = resistanceData[12].damage_multiplier,
        resistancePsy = resistanceData[13].damage_multiplier,
        resistanceGlace = resistanceData[14].damage_multiplier,
        resistanceDragon = resistanceData[15].damage_multiplier,
        resistanceTenebres = resistanceData[16].damage_multiplier,
        resistanceFee = resistanceData[17].damage_multiplier,
        HP = stats.hp,
        attack = stats.attack,
        defense = stats.defense,
        special_attack = stats.special_attack,
        special_defense = stats.special_defense,
        speed = stats.speed,
        date_ajout = formatted
    )
}

fun List<PokemonRoom>.fromRoomToDomain(): List<PokemonPojoDomain> {
    return map {
        PokemonPojoDomain(
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