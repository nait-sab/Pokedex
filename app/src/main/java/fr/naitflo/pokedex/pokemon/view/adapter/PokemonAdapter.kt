package fr.naitflo.pokedex.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.View
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

class PokemonAdapter(private val onItemClick: (PokemonPojoUI: PokemonPojoUI, view: View) -> Unit,) :
    ListAdapter<PokemonPojoUI, PokemonViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),onItemClick
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PokemonViewHolder(
    private val binding: PokemonItemBinding,
    onItemClick: (pokemonPojoUI: PokemonPojoUI, view: View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: PokemonPojoUI


    init {
        binding.root.setOnClickListener {
            onItemClick(ui, itemView)
        }
    }

    fun bind(PokemonPojoUI: PokemonPojoUI) {
        ui = PokemonPojoUI
        Glide.with(itemView.context)
            .load(PokemonPojoUI.sprite)
            .into(binding.pokemonItemSprite)
        Glide.with(itemView.context)
            .load(PokemonPojoUI.type1)
            .into(binding.pokemonItemEnergy)
        Glide.with(itemView.context)
            .load(PokemonPojoUI.type2)
            .into(binding.pokemonItemEnergy2)
        binding.pokemonItemNumero.text = "#" + PokemonPojoUI.pokedexId.toString()
        binding.pokemonItemNom.text = PokemonPojoUI.nom


    }
}