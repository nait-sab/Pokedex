package fr.naitflo.pokedex.pokemon.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import fr.naitflo.pokedex.databinding.ActivityPokemonListeBinding
import fr.naitflo.pokedex.firebase.LoginActivity
import fr.naitflo.pokedex.pokemon.view.adapter.PokemonAdapter
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI
import fr.naitflo.pokedex.pokemon.view.viewModel.PokemonViewModel

/**
 * Class : Pokemon Liste
 * Type : Activité
 * Content : List of pokemons found by API
 */
class PokemonListeActivity : AppCompatActivity() {
    private lateinit var viewModel: PokemonViewModel
    private lateinit var binding: ActivityPokemonListeBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var adapter: PokemonAdapter

    private var pokemonListObserver = Observer<List<PokemonPojoUI>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListeBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        adapter = PokemonAdapter();
        binding.pokemonListeContenu.layoutManager = LinearLayoutManager(this,
            RecyclerView.VERTICAL,false)
        binding.pokemonListeContenu.adapter = adapter
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

    override fun onStart() {
        super.onStart()
        viewModel.pokemonLiveData.observe(this, pokemonListObserver)
    }

    override fun onStop() {
        viewModel.pokemonLiveData.removeObserver(pokemonListObserver)
        super.onStop()
    }

    private fun deconnexion() {
        firebaseAuth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun viderListe() {
        viewModel.deleteAll()
    }

    private fun ajouterPokemon() {
        viewModel.fetchNewPokemon()
    }
}