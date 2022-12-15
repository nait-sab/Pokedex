package fr.naitflo.pokedex.architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.naitflo.pokedex.R

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)
    }
}