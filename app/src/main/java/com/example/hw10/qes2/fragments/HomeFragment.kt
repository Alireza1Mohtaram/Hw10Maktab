package com.example.hw10.qes2.fragments

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw10.R
import com.example.hw10.databinding.HomeFragmentBinding
import com.example.hw10.qes2.models.Fav
import com.example.hw10.qes2.models.MovieHandler
import com.example.hw10.qes2.models.RecyclerHomeMovieAdapter
import com.google.android.material.imageview.ShapeableImageView

class HomeFragment : Fragment(R.layout.home_fragment) {


    lateinit var binding: HomeFragmentBinding
    lateinit var movieHandler: MovieHandler

    var isAddedRecyclerItems = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(requireView())
        movieHandler = MovieHandler(this)
        initMovies(this.requireContext())

    }

    private fun initMovies(context: Context) {
        val d1 = context.resources.getDrawable(R.drawable.img_1) as BitmapDrawable
        val d2 = context.resources.getDrawable(R.drawable.img_2) as BitmapDrawable
        val d3 = context.resources.getDrawable(R.drawable.img_3) as BitmapDrawable
        val d4 = context.resources.getDrawable(R.drawable.img11) as BitmapDrawable
        val d5 = context.resources.getDrawable(R.drawable.img_4) as BitmapDrawable
        val d6 = context.resources.getDrawable(R.drawable.img5) as BitmapDrawable
        val d7 = context.resources.getDrawable(R.drawable.img6) as BitmapDrawable
        val d8 = context.resources.getDrawable(R.drawable.img7) as BitmapDrawable
        val d9 = context.resources.getDrawable(R.drawable.img12) as BitmapDrawable
        val d10 = context.resources.getDrawable(R.drawable.img8) as BitmapDrawable
        val d11 = context.resources.getDrawable(R.drawable.img9) as BitmapDrawable
        val d12 = context.resources.getDrawable(R.drawable.img10) as BitmapDrawable

        if (!isAddedRecyclerItems) {
            movieHandler.addMovie("HERO", Fav.NOFAV, d1.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d2.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d3.bitmap)

            movieHandler.addMovie("HERO", Fav.NOFAV, d4.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d5.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d6.bitmap)

            movieHandler.addMovie("HERO", Fav.NOFAV, d7.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d8.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d9.bitmap)

            movieHandler.addMovie("HERO", Fav.NOFAV, d10.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d11.bitmap)
            movieHandler.addMovie("HERO", Fav.NOFAV, d12.bitmap)


        }

    }


    fun setMovies() {
        isAddedRecyclerItems = true
        binding.recyclerView2.adapter = RecyclerHomeMovieAdapter(movieHandler.getAllMovies(), this)
        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(), 3)

    }

    override fun onResume() {
        super.onResume()
        setMovies()

    }


}