package com.example.pokemonappvk.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.Resource
import com.example.pokemonappvk.R
import com.example.pokemonappvk.databinding.FragmentDetailsBinding
import com.example.pokemonappvk.domain.modelpokeimage.Cries
import com.example.pokemonappvk.domain.modelpokeimage.ModeImagePoke
import com.example.pokemonappvk.domain.modelpokeimage.Species
import com.example.pokemonappvk.domain.modelpokeimage.Sprites
import com.example.pokemonappvk.presentation.main.MainViewModel
import com.example.pokemonappvk.presentation.utils.appComponent


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

        mBind.tvTitleDetailed.text = "Pokemon $pokemonName"


        Glide.with(this)
            .load(pokemonImageUrl)
            .placeholder(R.drawable.load_img)
            .into(mBind.imgDetailed)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getDetailsInfo(pokemonName)
        viewModel.myDetailsInfo.observe(viewLifecycleOwner) { response ->
            val pokemonDetails = response.body()
            pokemonDetails?.let {
                val abilitiesDetails = it.stats.map { stats ->
                    "Базовый показатель: ${stats.base_stat}\nУсилие: ${stats.effort}\n" +
                            "Название: ${stats.stat.name}"
                }
                mBind.tvDescription.text = abilitiesDetails.joinToString("\n\n")
            }
        }
    }


    fun inject() {
        requireContext().appComponent().inject(this)
    }
}