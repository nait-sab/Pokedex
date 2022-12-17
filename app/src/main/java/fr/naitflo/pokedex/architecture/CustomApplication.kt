package fr.naitflo.pokedex.architecture
import android.app.Application
import androidx.room.Room


class CustomApplication : Application() {

    // Create unique instance of this class
    companion object {
        lateinit var instance: CustomApplication
    }


    val mApplicationDatabase: CustomRoomDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            CustomRoomDatabase::class.java,
            "BDDPokedex"
        ).fallbackToDestructiveMigration().build()
    }

    // When application goes to onCreate, this means we can set the instance
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}