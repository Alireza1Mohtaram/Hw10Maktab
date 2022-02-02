package com.example.hw10.qes2.models

import android.graphics.Bitmap

class Movie() {

     var id: Int = 0
     var title: String = "No title"
        set(value) {
            field = if (field.isNotBlank()) value
            else "No title"
        }
     var favState: Fav = Fav.NOFAV
     var posterId: Bitmap? = null


    constructor(id:Int, title: String, favState: Fav, posterId: Bitmap?) : this() {
        this.id = id
        this.title = title
        this.favState = favState
        this.posterId = posterId
    }

    override fun toString(): String {
        return "Movie(id=$id, title='$title', favState=$favState, posterId=$posterId)"
    }


}