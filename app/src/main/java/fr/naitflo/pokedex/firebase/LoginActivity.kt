package fr.naitflo.pokedex.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import fr.naitflo.pokedex.R
import fr.naitflo.pokedex.databinding.ActivityLoginBinding
import fr.naitflo.pokedex.pokemon.view.activity.PokemonListeActivity

/**
 * Class : Login
 * Type : Activité
 * Content : Login of the App
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(binding.root)
        initBinding()
    }

    private fun initBinding() {
        binding.boutonAllerInscription.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.boutonConnexion.setOnClickListener {
            connexion()
        }
    }

    private fun connexion() {
        val mail = binding.loginMail.text.toString()
        val password = binding.loginPassword.text.toString()

        if (mail.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener {
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