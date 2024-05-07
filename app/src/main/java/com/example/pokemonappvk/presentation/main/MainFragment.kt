package com.example.pokemonappvk.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonappvk.R
import com.example.pokemonappvk.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var mBind: FragmentMainBinding
    private lateinit var adapter: MainAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBind = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MainAdapter(requireActivity().supportFragmentManager)
        initViews()
    }

    fun initViews() {
        recyclerView = mBind.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getListPoke()
        viewModel.myListPoke.observe(viewLifecycleOwner) { response ->
            val products = response.body()?.results
            products?.let { adapter.submitList(it) }
        }
    }
}

