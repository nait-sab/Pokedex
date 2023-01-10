package fr.naitflo.pokedex.architecture
import android.app.Application
import androidx.room.Room


class App : Application() {
    companion object {
        lateinit var instance: App
    }

    val appDatabase: Database by lazy {
        Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "BDDPokedex"
        ).fallbackToDestructiveMigration().build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}