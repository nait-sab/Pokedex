package fr.naitflo.pokedex.pokemon.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import fr.naitflo.pokedex.databinding.ActivityPokemonInfoBinding
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI

/**
 * Class : Pokemon Info
 * Type : Activité
 * Content : Content of the target pokemon
 */
class PokemonInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonInfoBinding
    private lateinit var pokemon: PokemonPojoUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonInfoBinding.inflate(layoutInflater)

        //TODO:getSerializableExtra a changer dans le future
        pokemon = intent.getSerializableExtra("donneesPokemon") as PokemonPojoUI

        setContentView(binding.root)
        initBinding()
    }

    private fun initBinding() {

        binding.pokemonInfoNom.text = pokemon.nom

        Glide.with(this)
            .load(pokemon.type1)
            .into(binding.pokemonInfoEnergy)

        Glide.with(this)
            .load(pokemon.type2)
            .into(binding.pokemonInfoEnergy2)

        binding.pokemonInfoFermer.setOnClickListener {
            fermer()
        }
    }

    private fun fermer() {
        startActivity(Intent(this, PokemonListeActivity::class.java))
    }
}