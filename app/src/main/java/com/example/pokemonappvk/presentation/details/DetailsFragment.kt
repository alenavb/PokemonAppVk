package com.example.pokemonappvk.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pokemonappvk.R
import com.example.pokemonappvk.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var mBind: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBind = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return mBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonName = arguments?.getString("pokemonName") ?: ""
        val pokemonImageUrl = arguments?.getString("pokemonImageUrl") ?: ""

        mBind.tvTitleDetailed.text = pokemonName
        Glide.with(this)
            .load(pokemonImageUrl)
            .placeholder(R.drawable.load_img)
            .into(mBind.imgDetailed)
    }
}