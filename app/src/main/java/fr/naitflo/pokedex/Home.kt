package fr.naitflo.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import fr.naitflo.pokedex.firebase.LoginActivity

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1 - Charger tout ce qui est nécéssaire à l'app
        //Thread.sleep(3000) // à retirer au rendu final sauf si on a rien à la place

        // 2 - Fin du splash screen, démarrage de l'app
        val splashscreen = installSplashScreen()
        setContentView(R.layout.activity_home)

        // 3 - Déplacer dans la connexion
        startActivity(Intent(this, LoginActivity::class.java))
    }
}