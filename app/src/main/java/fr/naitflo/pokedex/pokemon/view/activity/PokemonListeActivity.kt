package fr.naitflo.pokedex.pokemon.view.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import fr.naitflo.pokedex.R
import fr.naitflo.pokedex.databinding.ActivityPokemonInfoBinding
import fr.naitflo.pokedex.databinding.ActivityPokemonListeBinding
import fr.naitflo.pokedex.firebase.LoginActivity
import fr.naitflo.pokedex.pokemon.view.adapter.PokemonAdapter
import fr.naitflo.pokedex.pokemon.view.model.MyPokemonForRecyclerView
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

    private var pokemonListObserver = Observer<List<MyPokemonForRecyclerView>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonListeBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        adapter = PokemonAdapter() { item, view ->
            onItemClick(item, view)
        }

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

        binding.pokemonListeContenu.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL, false
        )

        binding.pokemonListeContenu.adapter = adapter

        val utilisateurID = getString(R.string.pokemon_liste_id) + " " + firebaseAuth.uid
        binding.pokemonListeId.text = utilisateurID;
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

    private fun onItemClick(pokemonPojoUI: PokemonPojoUI, view: View) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        val i = Intent(this, PokemonInfoActivity::class.java)
        val pokemonPojoUI: PokemonPojoUI = pokemonPojoUI
        i.putExtra("donneesPokemon", pokemonPojoUI)
        sendnotif(pokemonPojoUI)
        startActivity(i)
    }

    companion object {
        private const val CHANNEL_ID = "item_notif_id"
        private const val CHANNEL_NAME = "item_notif_name"
        private const val CHANNEL_DESCRIPTION = "Channel for pokemon notif"
        private const val NOTIFICATION_ID = 42
    }

    private fun sendnotif(pokemonPojoUI: PokemonPojoUI) {
        val mNotificationManager: NotificationManager =
            this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = CHANNEL_DESCRIPTION
        }
        mNotificationManager.createNotificationChannel(notificationChannel)
        createNotificationCompatBuilder(pokemonPojoUI)
    }

    private fun createNotificationCompatBuilder(pokemonPojoUI: PokemonPojoUI) {
        val notificationCompat = NotificationCompat.Builder(this, CHANNEL_ID)
            .setAutoCancel(true)
            .setContentTitle("#" + pokemonPojoUI.pokedexId.toString() + " " + pokemonPojoUI.nom)
            .setAutoCancel(true)
            .setSmallIcon(fr.naitflo.pokedex.R.drawable.ic_pokeball)
            .setColor(resources.getColor(fr.naitflo.pokedex.R.color.couleurPrincipale))
            .setColorized(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(NOTIFICATION_ID, notificationCompat.build())
        }
    }
}