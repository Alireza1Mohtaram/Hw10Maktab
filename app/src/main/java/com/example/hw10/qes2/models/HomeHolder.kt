package com.example.hw10.qes2.models

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw10.R
import com.google.android.material.imageview.ShapeableImageView

class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var poster:ShapeableImageView = itemView.findViewById(R.id.image_home_item)
    var title: TextView = itemView.findViewById(R.id.tv_home_item)
    var likeBtn :ShapeableImageView = itemView.findViewById(R.id.like_btn_home_item)
}
