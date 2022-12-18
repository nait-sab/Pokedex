package fr.naitflo.pokedex.pokemon.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import fr.naitflo.pokedex.databinding.ActivityPokemonListeBinding
import fr.naitflo.pokedex.firebase.LoginActivity

/**
 * Class : Pokemon Liste
 * Type : Activité
 * Content : List of pokemons found by API
 */
class PokemonListeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonListeBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListeBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(binding.root)
        initBinding()
    }

    private fun initBinding() {
        binding.pokemonListeLogoff.setOnClickListener {
            deconnexion()
        }

        binding.pokemonListeDelete.setOnClickListener() {
            viderListe()
        }

        binding.pokemonListeAdd.setOnClickListener() {
            ajouterPokemon()
        }
    }

    private fun deconnexion() {
        firebaseAuth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun viderListe() {}

    private fun ajouterPokemon() {}
}