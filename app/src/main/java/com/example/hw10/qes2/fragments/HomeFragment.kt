package com.example.hw10.qes2.fragments

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hw10.R
import com.example.hw10.databinding.HomeFragmentBinding
import com.example.hw10.qes2.models.Fav
import com.example.hw10.qes2.models.MovieHandler
import com.google.android.material.imageview.ShapeableImageView

class HomeFragment : Fragment(R.layout.home_fragment) {


    lateinit var binding: HomeFragmentBinding
    lateinit var movieHandler: MovieHandler


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(requireView())
        movieHandler = MovieHandler(this)
        initMovies(this.requireContext())
        setMovies()

        binding.likeBtn1.setOnClickListener {
            updateFavoriteState(0, it as ShapeableImageView)
            Log.d("Fav", "${movieHandler.getMovieWithItem(0).favState}")
        }

    }

    private fun initMovies(context: Context) {
        val d1 = context.resources.getDrawable(R.drawable.img_1) as BitmapDrawable
        movieHandler.addMovie("HERO", Fav.NOFAV, d1.bitmap)

    }


    fun setMovies() {
        binding.image1.setImageBitmap(movieHandler.getMovieWithItem(0).posterId)
        binding.tv1.text = ((movieHandler.getMovieWithItem(0).title))
    }

    private fun updateFavoriteState(id: Int, btn: ShapeableImageView) {
        val fav = movieHandler.changeFavState(id)
        btn.changeSate(fav)
    }

    private fun ShapeableImageView.changeSate(fav: Fav) {
        if (fav == Fav.ISFAV) this.setImageResource(R.drawable.ic_baseline_favorite_24)
        else this.setImageResource(R.drawable.ic_baseline_favorite_border_24)
    }

    override fun onResume() {
        super.onResume()
        movieHandler.getFavs().forEach {
            if (it.id == 0) binding.likeBtn1.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }
}