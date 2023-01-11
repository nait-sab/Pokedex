package fr.naitflo.pokedex.pokemon.view.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import fr.naitflo.pokedex.databinding.ActivityPokemonInfoBinding
import fr.naitflo.pokedex.databinding.ActivityPokemonListeBinding
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

        //TODO:getSerializableExtra a changer dans le future si trouve mieux
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

        Glide.with(this)
            .load(pokemon.image)
            .into(binding.pokemonInfoImg)

        binding.pokemonInfoNumero.text = pokemon.pokedexId.toString()

        binding.pokemonInfoPv.text = pokemon.HP.toString()
        binding.pokemonInfoAttaque.text = pokemon.attack.toString()
        binding.pokemonInfoDefense.text = pokemon.defense.toString()
        binding.pokemonInfoAttaqueS.text = pokemon.special_attack.toString()
        binding.pokemonInfoDefenseS.text = pokemon.special_defense.toString()
        binding.pokemonInfoVitesse.text = pokemon.speed.toString();

        binding.pokemonInfoFermer.setOnClickListener {
            fermer()
        }
        binding.pokemonInfoImg.setOnClickListener{
            sendnotif()
        }
    }

    private fun fermer() {
        startActivity(Intent(this, PokemonListeActivity::class.java))
    }

    companion object {
        const val TAG = "CustomNotificationManager"
        private const val CHANNEL_ID = "demo_purpose"
        private const val CHANNEL_NAME = "demo purpose channel id"
        private const val CHANNEL_DESCRIPTION = "This channel will received only demo notification"
        private const val REQUEST_CODE = 94043
        private const val NOTIFICATION_ID = 42
    }
    private fun sendnotif() {
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
        createNotificationCompatBuilder(binding)
    }
    private fun createNotificationCompatBuilder(binding: ActivityPokemonInfoBinding) {
        val textView: TextView =  findViewById(fr.naitflo.pokedex.R.id.pokemon_info_nom)


        val notificationCompat = NotificationCompat.Builder(this, CHANNEL_ID)
            .setAutoCancel(true)
            .setContentTitle("#"+binding.pokemonInfoNumero.text+" "+textView.text.toString())
            .setAutoCancel(true)
            .setSmallIcon(fr.naitflo.pokedex.R.drawable.ic_pokeball)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(NOTIFICATION_ID, notificationCompat.build())
        }
    }
}