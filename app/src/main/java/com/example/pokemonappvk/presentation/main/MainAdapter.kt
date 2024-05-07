package com.example.pokemonappvk.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonappvk.R
import com.example.pokemonappvk.domain.modelpokeimage.ModeImagePoke
import com.example.pokemonappvk.domain.modelpokelist.Result
import com.example.pokemonappvk.presentation.details.DetailsFragment

class MainAdapter(private val fragmentManager: FragmentManager) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    private var listAllPoke = emptyList<Result>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val imageView = view.findViewById<ImageView>(R.id.imageItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pokemon = listAllPoke[position]

        Glide.with(holder.itemView.context)
            .load(getImageUrl(pokemon.url))
            .placeholder(R.drawable.load_img)
            .into(holder.imageView)

        holder.tvName.text = pokemon.name

        holder.itemView.setOnClickListener {

            val bundle = Bundle().apply {
                putString("pokemonName", pokemon.name)
                putString("pokemonImageUrl", getImageUrl(pokemon.url))
            }
            val detailsFragment = DetailsFragment().apply {
                arguments = bundle
            }
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, detailsFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return listAllPoke.size
    }

    fun submitList(list: List<Result>) {
        listAllPoke = list
        notifyDataSetChanged()
    }

    private fun getImageUrl(pokemonUrl: String): String {
        val pokemonId = pokemonUrl.split("/").takeLast(2).first()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${pokemonId}.png"
    }
}
