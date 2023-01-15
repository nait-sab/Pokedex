package fr.naitflo.pokedex.pokemon.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        pokemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("donneesPokemon", PokemonPojoUI::class.java)
        } else {
            intent.getParcelableExtra("donneesPokemon")
        }!!

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

        binding.pokemonInfoNumero.text = "#" + pokemon.pokedexId.toString()

        // Stats
        binding.pokemonInfoPv.text = pokemon.HP.toString()
        binding.pokemonInfoAttaque.text = pokemon.attack.toString()
        binding.pokemonInfoDefense.text = pokemon.defense.toString()
        binding.pokemonInfoAttaqueS.text = pokemon.special_attack.toString()
        binding.pokemonInfoDefenseS.text = pokemon.special_defense.toString()
        binding.pokemonInfoVitesse.text = pokemon.speed.toString();

        // Resistances
        binding.pokemonInfoResNormalTexte.text = pokemon.resistanceNormal.toString();
        binding.pokemonInfoResCombatTexte.text = pokemon.resistanceCombat.toString();
        binding.pokemonInfoResVolTexte.text = pokemon.resistanceVol.toString();
        binding.pokemonInfoResPoisonTexte.text = pokemon.resistancePoison.toString();
        binding.pokemonInfoResSolTexte.text = pokemon.resistanceSol.toString();
        binding.pokemonInfoResRocheTexte.text = pokemon.resistanceRoche.toString();
        binding.pokemonInfoResInsecteTexte.text = pokemon.resistanceInsecte.toString();
        binding.pokemonInfoResSpectreTexte.text = pokemon.resistanceSpectre.toString();
        binding.pokemonInfoResAcierTexte.text = pokemon.resistanceAcier.toString();
        binding.pokemonInfoResFeuTexte.text = pokemon.resistanceFeu.toString();
        binding.pokemonInfoResEauTexte.text = pokemon.resistanceEau.toString();
        binding.pokemonInfoResPlanteTexte.text = pokemon.resistancePlante.toString();
        binding.pokemonInfoResElectrikTexte.text = pokemon.resistanceElectrik.toString();
        binding.pokemonInfoResPsyTexte.text = pokemon.resistancePsy.toString();
        binding.pokemonInfoResGlaceTexte.text = pokemon.resistanceGlace.toString();
        binding.pokemonInfoResDragonTexte.text = pokemon.resistanceDragon.toString();
        binding.pokemonInfoResTenebreTexte.text = pokemon.resistanceTenebres.toString();
        binding.pokemonInfoResFeeTexte.text = pokemon.resistanceFee.toString();

        //Icones Resistances
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/f/fb/Normal.png")
            .into(binding.pokemonInfoResNormalIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/7/7f/Flying.png")
            .into(binding.pokemonInfoResVolIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/3/30/Fire.png")
            .into(binding.pokemonInfoResFeuIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/9/9d/Water.png")
            .into(binding.pokemonInfoResEauIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/c/c5/Grass.png")
            .into(binding.pokemonInfoResPlanteIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/0/05/Poison.png")
            .into(binding.pokemonInfoResPoisonIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/3/30/Fighting.png")
            .into(binding.pokemonInfoResCombatIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/2/21/Psychic.png")
            .into(binding.pokemonInfoResPsyIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/8/8f/Ground.png")
            .into(binding.pokemonInfoResSolIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/a/ab/Ghost.png")
            .into(binding.pokemonInfoResSpectreIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/c/c9/Steel.png")
            .into(binding.pokemonInfoResAcierIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/2/2f/Electric.png")
            .into(binding.pokemonInfoResElectrikIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/0/0b/Rock.png")
            .into(binding.pokemonInfoResRocheIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/7/77/Ice.png")
            .into(binding.pokemonInfoResGlaceIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/c/c7/Dragon.png")
            .into(binding.pokemonInfoResDragonIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/0/0e/Dark.png")
            .into(binding.pokemonInfoResTenebreIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/4/43/Fairy.png")
            .into(binding.pokemonInfoResFeeIcone)
        Glide.with(this)
            .load("https://static.wikia.nocookie.net/pokemongo/images/7/7d/Bug.png")
            .into(binding.pokemonInfoResInsecteIcone)


        binding.pokemonInfoFermer.setOnClickListener {
            fermer()
        }
    }

    private fun fermer() {
        startActivity(Intent(this, PokemonListeActivity::class.java))
    }
}