package com.example.hw10.qes2.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.hw10.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var navigition: NavController
    lateinit var buttomNav: BottomNavigationView
  //  var bind = MovieHolder by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigition = Navigation.findNavController(this, R.id.nav_host_fragment_container)


        buttomNav = findViewById(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(buttomNav, navigition)

        buttomNav.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.miHome -> navigition.navigate(R.id.homeFragment)
                R.id.miComing -> navigition.navigate(R.id.coomingsoonFragment)
                R.id.miFavorite ->navigition.navigate(R.id.favFragment)
                R.id.miProfile -> navigition.navigate(R.id.profileFragment)
            }
            true
        }
    }


}





