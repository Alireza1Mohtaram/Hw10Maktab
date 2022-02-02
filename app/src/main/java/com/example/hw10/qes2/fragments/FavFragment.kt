package com.example.hw10.qes2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw10.R
import com.example.hw10.databinding.FavFragmentBinding
import com.example.hw10.qes2.models.MovieHandler

class FavFragment : Fragment(R.layout.fav_fragment) {

    lateinit var binding :FavFragmentBinding
    lateinit var movieHandler : MovieHandler

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FavFragmentBinding.bind(requireView())
        movieHandler = MovieHandler(this)

    }
    private fun setFavoriteItems() {
        val list = movieHandler.getFavs()
        var adapter= RecyclerMoviesAdpter(list)
        println(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
    }

    override fun onResume() {
        super.onResume()
        setFavoriteItems()
    }
}