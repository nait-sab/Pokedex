package fr.naitflo.pokedex.pokemon.data.mapper

import fr.naitflo.pokedex.pokemon.data.model.PokemonRetrofit
import fr.naitflo.pokedex.pokemon.data.model.PokemonRoom
import fr.naitflo.pokedex.pokemon.domain.model.PokemonPojoDomain

fun PokemonRetrofit.toRoom(): PokemonRoom {
    return PokemonRoom(
        nom = nom,
        pokedexId = pokedexId,
        image = image,
        sprite = sprite,
        type1 = typedata[0].image,
        type2 = typedata[1].image
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
            type2 = it.type2
        )
    }
}