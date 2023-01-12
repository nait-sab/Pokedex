package fr.naitflo.pokedex.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.naitflo.pokedex.databinding.PokemonFooterBinding
import fr.naitflo.pokedex.databinding.PokemonHeaderBinding
import fr.naitflo.pokedex.databinding.PokemonItemBinding
import fr.naitflo.pokedex.pokemon.view.model.PokemonPojoUI
import fr.naitflo.pokedex.pokemon.view.model.MyPokemonForRecyclerView
import fr.naitflo.pokedex.pokemon.view.model.PokemonFooter
import fr.naitflo.pokedex.pokemon.view.model.PokemonHeader


val diffUtils = object : DiffUtil.ItemCallback<MyPokemonForRecyclerView>() {
    override fun areItemsTheSame(
        oldItem: MyPokemonForRecyclerView,
        newItem: MyPokemonForRecyclerView
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: MyPokemonForRecyclerView,
        newItem: MyPokemonForRecyclerView
    ): Boolean {
        return oldItem == newItem
    }

}

class PokemonAdapter(
    private val onItemClick: (pokemonPojoUI: PokemonPojoUI, view: View) -> Unit,
) : ListAdapter<MyPokemonForRecyclerView, RecyclerView.ViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        MyItemType.ROW.type -> {
            PokemonViewHolder(
                PokemonItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), onItemClick
            )
        }

        MyItemType.HEADER.type -> {
            PokemonHeaderViewHolder(
                PokemonHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
        MyItemType.FOOTER.type -> {
            PokemonViewFooterHolder(
                PokemonFooterBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
        else -> throw RuntimeException("Wrong view type received $viewType")
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


        fun bind(pokemonPojoUI: PokemonPojoUI) {
            ui = pokemonPojoUI

            Glide.with(itemView.context)
                .load(ui.sprite)
                .into(binding.pokemonItemSprite)
            Glide.with(itemView.context)
                .load(ui.type1)
                .into(binding.pokemonItemEnergy)
            Glide.with(itemView.context)
                .load(ui.type2)
                .into(binding.pokemonItemEnergy2)

            binding.pokemonItemNom.text = ui.nom
            binding.pokemonItemNumero.text = "#" + ui.pokedexId

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PokemonPojoUI -> MyItemType.ROW.type
            is PokemonHeader -> MyItemType.HEADER.type
            is PokemonFooter -> MyItemType.FOOTER.type
            else -> {
                1
            }
        }
    }

    class PokemonHeaderViewHolder(
        private val binding: PokemonHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(PokemonHeader: PokemonHeader) {
            binding.pokemonGenerationHeader.text = "Génération " + PokemonHeader.header
        }
    }

    class PokemonViewFooterHolder(
        private val binding: PokemonFooterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonFooter: PokemonFooter) {
            binding.pokemonGenerationFooter.text = pokemonFooter.footer
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as PokemonViewHolder).bind(
                getItem(
                    position
                ) as PokemonPojoUI
            )
            MyItemType.HEADER.type -> (holder as PokemonHeaderViewHolder).bind(
                getItem(
                    position
                ) as PokemonHeader
            )
            MyItemType.FOOTER.type -> (holder as PokemonViewFooterHolder).bind(
                getItem(
                    position
                ) as PokemonFooter
            )
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }


}


enum class MyItemType(val type: Int) {
    ROW(0), HEADER(1), FOOTER(2)
}