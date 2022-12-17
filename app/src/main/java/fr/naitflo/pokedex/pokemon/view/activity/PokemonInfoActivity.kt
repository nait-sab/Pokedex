package fr.naitflo.pokedex.pokemon.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.naitflo.pokedex.R

/**
 * Class : Pokemon Info
 * Type : Activité
 * Content : Content of the target pokemon
 */
class PokemonInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_info)
    }
}