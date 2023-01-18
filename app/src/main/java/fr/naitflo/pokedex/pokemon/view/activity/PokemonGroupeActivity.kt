package fr.naitflo.pokedex.pokemon.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.naitflo.pokedex.R
import fr.naitflo.pokedex.databinding.ActivityPokemonGroupeBinding
import fr.naitflo.pokedex.databinding.ActivityPokemonInfoBinding

class PokemonGroupeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonGroupeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonGroupeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pokemonGroupeFermer.setOnClickListener {
            fermer()
        }
    }

    private fun fermer() {
        startActivity(Intent(this, PokemonListeActivity::class.java))
    }
}