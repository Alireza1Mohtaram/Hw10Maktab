package com.example.hw10.qes2.models

import androidx.lifecycle.ViewModel

public class DataHolder : ViewModel() {

    var idInc :Int = 0
    var movieList = mutableListOf<Movie>()
}