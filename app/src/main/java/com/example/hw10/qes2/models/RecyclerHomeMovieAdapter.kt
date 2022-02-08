package com.example.hw10.qes2.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw10.R
import com.example.hw10.qes2.fragments.HomeFragment
import com.google.android.material.imageview.ShapeableImageView

class RecyclerHomeMovieAdapter (movies:MutableList<Movie>,var fragment: HomeFragment): RecyclerView.Adapter<HomeHolder>() {

    var moviesItem = movies
    lateinit var movieHandler: MovieHandler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieItem = inflater.inflate(R.layout.home_recycler_item,parent,false)
        return HomeHolder(movieItem)

    }
    override fun onBindViewHolder(holder: HomeHolder, position: Int) {

        val m = moviesItem[position]
        if (m.favState == Fav.ISFAV){
            holder.likeBtn.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        movieHandler = MovieHandler(fragment)
        holder.title.text= m.title
        holder.poster.setImageBitmap( m.posterId)
        holder.likeBtn.setOnClickListener {
            updateFavoriteState(position,it as ShapeableImageView)
        }
    }

    override fun getItemCount(): Int {
        return moviesItem.size
    }

    private fun updateFavoriteState(id: Int, btn: ShapeableImageView) {
        val fav = movieHandler.changeFavState(id)
        btn.changeSate(fav)
    }

    private fun ShapeableImageView.changeSate(fav: Fav) {
        if (fav == Fav.ISFAV) this.setImageResource(R.drawable.ic_baseline_favorite_24)
        else this.setImageResource(R.drawable.ic_baseline_favorite_border_24)
    }

}