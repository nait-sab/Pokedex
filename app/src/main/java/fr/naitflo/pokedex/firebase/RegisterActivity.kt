package fr.naitflo.pokedex.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import fr.naitflo.pokedex.R
import fr.naitflo.pokedex.databinding.ActivityRegisterBinding
import fr.naitflo.pokedex.pokemon.view.activity.PokemonListeActivity

/**
 * Class : Register
 * Type : Activité
 * Content : Register of the App
 */
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(binding.root)
        initBinding()
    }

    private fun initBinding() {
        binding.boutonAllerConnexion.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.boutonInscription.setOnClickListener {
            inscription()
        }
    }

    private fun inscription() {
        val mail = binding.inscriptionMail.text.toString()
        val password = binding.inscriptionPassword.text.toString()

        if (mail.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    startActivity(Intent(this, PokemonListeActivity::class.java))
                } else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show()
        }
    }
}