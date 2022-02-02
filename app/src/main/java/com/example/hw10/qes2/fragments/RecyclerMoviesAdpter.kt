package com.example.hw10.qes2.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw10.R
import com.example.hw10.qes2.models.Movie
import com.google.android.material.imageview.ShapeableImageView

class RecyclerMoviesAdpter(movies:MutableList<Movie>): RecyclerView.Adapter<RecyclerMoviesAdpter.RecyclerItemAdapter> (){

    var moviesItem = movies
    inner class RecyclerItemAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var poster:ShapeableImageView = itemView.findViewById(R.id.poster)
        var title: TextView = itemView.findViewById(R.id.tvTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemAdapter {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val movieItem = inflater.inflate(R.layout.recycler_item,parent,false)
        return RecyclerItemAdapter(movieItem)

    }

    override fun onBindViewHolder(holder: RecyclerItemAdapter, position: Int) {

        val m = moviesItem[position]
        holder.title.text= m.title
        holder.poster.setImageBitmap( m.posterId)

    }

    override fun getItemCount(): Int {
    return moviesItem.size
    }


}

