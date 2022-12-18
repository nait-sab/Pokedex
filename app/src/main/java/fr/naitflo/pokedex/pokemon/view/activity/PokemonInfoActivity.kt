package fr.naitflo.pokedex.pokemon.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.naitflo.pokedex.R
import fr.naitflo.pokedex.databinding.ActivityPokemonInfoBinding
import fr.naitflo.pokedex.firebase.LoginActivity

/**
 * Class : Pokemon Info
 * Type : Activité
 * Content : Content of the target pokemon
 */
class PokemonInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBinding()
    }

    private fun initBinding() {
        binding.pokemonInfoFermer.setOnClickListener {
            fermer()
        }
    }

    private fun fermer() {
        startActivity(Intent(this, PokemonListeActivity::class.java))
    }
}