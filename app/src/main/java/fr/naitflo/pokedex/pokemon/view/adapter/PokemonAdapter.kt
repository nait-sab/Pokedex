package fr.naitflo.pokedex.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI
import fr.naitflo.pokedex.databinding.PokemonItemBinding


val diffUtils = object : DiffUtil.ItemCallback<PokemonPojoUI>() {
    override fun areItemsTheSame(oldItem: PokemonPojoUI, newItem: PokemonPojoUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PokemonPojoUI, newItem: PokemonPojoUI): Boolean {
        return oldItem == newItem
    }
}

class PokemonAdapter : ListAdapter<PokemonPojoUI, PokemonViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PokemonViewHolder(
    private val binding: PokemonItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: PokemonPojoUI

    fun bind(PokemonPojoUI: PokemonPojoUI) {
        ui = PokemonPojoUI
        Glide.with(itemView.context)
            .load(PokemonPojoUI.sprite)
            .into(binding.pokemonItemSprite)
        Glide.with(itemView.context)
            .load(PokemonPojoUI.type1)
            .into(binding.pokemonItemEnergy)
        binding.pokemonItemNumero.text = PokemonPojoUI.pokedexId.toString()
        binding.pokemonItemNom.text = PokemonPojoUI.nom


    }
}