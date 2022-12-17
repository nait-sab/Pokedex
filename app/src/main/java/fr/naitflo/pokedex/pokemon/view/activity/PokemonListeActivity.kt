package fr.naitflo.pokedex.pokemon.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.naitflo.pokedex.R

/**
 * Class : Pokemon Liste
 * Type : Activité
 * Content : List of pokemons found by API
 */
class PokemonListeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_liste)
    }
}