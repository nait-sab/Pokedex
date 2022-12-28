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
            type2 = it.type2
        )
    }
}